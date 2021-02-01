package org.emoflon.ibex.gt.editor.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.emoflon.ibex.gt.editor.gT.EditorApplicationCondition;
import org.emoflon.ibex.gt.editor.gT.EditorCondition;
import org.emoflon.ibex.gt.editor.gT.EditorConditionReference;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;
import org.emoflon.ibex.gt.editor.gT.EditorSimpleCondition;

/**
 * Class which finds connected subpatterns in a pattern
 * 
 */
public class GTDisjointPatternFinder {
	
		List<Set<EditorNode>> currentSubgraphs;	
		EditorPattern flattenedPattern;
		boolean isDisjoint;
		Set<Set<EditorNode>> allSubgraphs;
	
	public GTDisjointPatternFinder(EditorPattern pattern) {
		Optional<EditorPattern> newPattern = getFlattenedPattern(pattern);
		allSubgraphs = new HashSet<Set<EditorNode>>();
		
		if(newPattern.isPresent()) flattenedPattern = newPattern.get();
		else throw new IllegalArgumentException("pattern could not be flattened");
		//disjoint patterns will not be searched for when there is more than one condition
		if(pattern.getConditions().size()>1 || pattern.isAbstract()) {
			isDisjoint = false;
			return;
		}
		calculateGraph(flattenedPattern);
		currentSubgraphs = checkDisjointPatterns(flattenedPattern);
		isDisjoint = currentSubgraphs.size() >1;
	}
	
	/**
	 * finds all nodes in a graph an maps the nodes if necessary; then finds the corresponding subgraphs
	 * @param pattern
	 * @return a map with the nodes and the connected subggraph
	 */
	private Map<EditorNode, Pair<Set<EditorNode>,Boolean>> calculateGraph(final EditorPattern pattern) {
		Map<EditorNode, Pair<Set<EditorNode>, Boolean>> flattenedGraph = new HashMap<EditorNode, Pair<Set<EditorNode>, Boolean>>();
		//insert the pattern nodes into the flattened graph
		List<EditorNode> signatureNodes = getNodesByOperator(pattern, EditorOperator.CONTEXT, EditorOperator.DELETE).stream()
				.filter(n -> !n.getName().startsWith("_")).collect(Collectors.toList());
		
		for(final EditorNode node: getNodesByOperator(pattern, EditorOperator.CONTEXT, EditorOperator.DELETE)) {
			flattenedGraph.put(node, new Pair<Set<EditorNode>, Boolean>(findReferences(node), Boolean.valueOf(false)));
		}
		
		//insert the condition nodes into the flattened graph
		if(!pattern.getConditions().isEmpty()) {
			for(final EditorPattern conditionPattern: getConditionPatterns(pattern.getConditions().get(0))){
				
				//recursively search for the subgraphs of the conditions and finds all nodes of the conditionGraph that are signature nodes of the pattern
				for(final Entry<EditorNode,Pair<Set<EditorNode>, Boolean>> entry: calculateGraph(conditionPattern).entrySet()) {
					List<EditorNode> keyNode = flattenedGraph.keySet().stream()
						.filter(n -> n.getName().equals(entry.getKey().getName()) && signatureNodes.contains(n)).collect(Collectors.toList());
					
					if(keyNode.size() >1) System.out.println("There was an error when calculating subpatterns");
					else if(keyNode.size() == 1) {
						flattenedGraph.computeIfPresent(keyNode.get(0), (k, v) ->{
							Set<EditorNode> references = v.getLeft();
							references.addAll(entry.getValue().getLeft());
							//the local node is also put into the references for later use
							references.add(entry.getKey());
							v.setLeft(references);
							return v;
						});
					}
					else {
						flattenedGraph.put(entry.getKey(), entry.getValue());
					}
				}			
				
			}
		}
		findDisjointSubpatterns(flattenedGraph, signatureNodes);
		return flattenedGraph;
	}
		
	/**
	 * finds all disjoint patterns in a pattern
	 * @return
	 */
	private void findDisjointSubpatterns(final Map<EditorNode, Pair<Set<EditorNode>, Boolean>> flattenedGraph, final List<EditorNode> signatureNodes) {
		for(final EditorNode node: flattenedGraph.keySet().stream().filter(n -> n.getOperator() != EditorOperator.CREATE).collect(Collectors.toList())) {
			//checks if node is already in a subgraph
			if(flattenedGraph.get(node).getRight().booleanValue()) continue;
			else {
				//do a breadth-first search
				searchSubgraph(flattenedGraph, signatureNodes, node);
			}
		}						
	}

	/**
	 * searches all connected nodes in a graph that the node can access
	 * 
	 * @param allNodes all nodes in the graph
	 * @param node the source node
	 * @return all nodes that the source node can access directly or indirectly
	 */
	private void searchSubgraph(final Map<EditorNode, Pair<Set<EditorNode>, Boolean>> flattenedGraph, final List<EditorNode> signatureNodes, final EditorNode node) {
		Queue<EditorNode> nodeQueue = new LinkedList<EditorNode>();
		Set<EditorNode> subGraph = new HashSet<EditorNode>();
		//saves all visited nodes which were visited to avoid cycles
		Set<EditorNode> visitedNodes = new HashSet<EditorNode>();
		nodeQueue.add(node);
		
		while(!nodeQueue.isEmpty()) {
			EditorNode currentNode = nodeQueue.poll();
			//breaks free from cycles and if the node cant be found in the graph
			if(visitedNodes.contains(currentNode)||!flattenedGraph.containsKey(currentNode)&&
					!signatureNodes.stream().anyMatch(n -> n.getName().equals(currentNode.getName()))) continue;
			else {
				visitedNodes.add(currentNode);
				Pair<Set<EditorNode>, Boolean> currentValue = findNodeInGraph(flattenedGraph, currentNode, signatureNodes);
				
				//check if the node was visited in another subgraph
				if(currentValue.getRight().booleanValue()) {
					subGraph.addAll(currentValue.getLeft());
					visitedNodes.addAll(currentValue.getLeft());
					allSubgraphs.remove(currentValue.getLeft());
				}
				else {
					nodeQueue.addAll(currentValue.getLeft());
					setTrue(currentNode, flattenedGraph, signatureNodes);
					
					subGraph.add(currentNode);	
				}

			}
		}
		subGraph.forEach(n -> {
			if(flattenedGraph.containsKey(n)) {
				flattenedGraph.replace(n, new Pair<Set<EditorNode>, Boolean>(subGraph,Boolean.valueOf(true)));
			}		
		});
		allSubgraphs.add(subGraph);		
	}	
	
	/**
	 * finds the value of a node even if it is a local node overwritten by a signature node
	 */
	private Pair<Set<EditorNode>, Boolean> findNodeInGraph(final Map<EditorNode, Pair<Set<EditorNode>, Boolean>> flattenedGraph,
			final EditorNode node, final List<EditorNode> signatureNodes) {
		if(flattenedGraph.containsKey(node)) {
			return flattenedGraph.get(node);
		}
		else {
			List<EditorNode> signatureNode = signatureNodes.stream().filter(n -> n.getName().equals(node.getName())).collect(Collectors.toList());
			//find in all signature nodes which has the node
			if(signatureNode.size() == 1) {
				return flattenedGraph.get(signatureNode.get(0));
			}
		}
		throw new IllegalArgumentException("Something is wrong with the flattened Graph");
	}
	
	/**
	 * finds the value of a node and sets that the node was visited
	 */
	void setTrue(final EditorNode node, final Map<EditorNode, Pair<Set<EditorNode>, Boolean>> flattenedGraph, final List<EditorNode> signatureNodes) {
		if(flattenedGraph.containsKey(node)) {
			flattenedGraph.compute(node, (k, v) -> {
				v.setRight(Boolean.valueOf(true));
				return v;
			});
		}
		else {
			List<EditorNode> signatureNode = signatureNodes.stream().filter(n -> n.getName().equals(node.getName())).collect(Collectors.toList());
			//find in all signature nodes which has the node
			if(signatureNode.size() == 1) {
				flattenedGraph.compute(signatureNode.get(0), (k, v) -> {
					v.setRight(Boolean.valueOf(true));
					return v;
				});
			}else {
			throw new IllegalArgumentException("Something is wrong with the flattened Graph");
			}
		}
	}
	
	/**
	 * find all subpatterns that have signatureNodes of the main pattern
	 */
	private List<Set<EditorNode>> checkDisjointPatterns(final EditorPattern pattern) {
		List<EditorNode> signatureNodes = getNodesByOperator(pattern, EditorOperator.CONTEXT, EditorOperator.DELETE).stream()
				.filter(n -> !n.getName().startsWith("_")).collect(Collectors.toList());
		// removes all subgraphs that do not have any signature nodes
		List<Set<EditorNode>> subgraphs = new ArrayList<Set<EditorNode>>();
		for(Set<EditorNode> subpattern: allSubgraphs) {
			//subgraph should have at least one signature node
			if(!subpattern.stream().filter(n -> signatureNodes.contains(n)).collect(Collectors.toList()).isEmpty()) {
				subgraphs.add(subpattern);
			}
		}
		return subgraphs;
	}
	
	/**
	 * finds all references that a node has to other nodes that will be later used in a context pattern
	 */
	private Set<EditorNode> findReferences(final EditorNode node) {
		Set<EditorNode> references = new HashSet<EditorNode>();
		node.getReferences().stream().filter(n -> n.getOperator() != EditorOperator.CREATE).forEach(n -> references.add(n.getTarget()));
		return references;
	}
	
	/**
	 * formats the disjoint patterns for the GTValidator
	 */
	public static String getDisjointPatternFormat(List<Set<EditorNode>> nodeSet) {
		List<String> disjointPatterns = new ArrayList<String>();
		for(Set<EditorNode> set: nodeSet) {
			Set<String> nodeNames = set.stream().map(n -> n.getName()).collect(Collectors.toSet());
			String pattern = "{" + StringUtils.join(nodeNames, ", ") + "}";
			disjointPatterns.add(pattern);
		}
		return StringUtils.join(disjointPatterns, ", ");
	}
	
	private Optional<EditorPattern> getFlattenedPattern(final EditorPattern editorPattern) {
		if (editorPattern.getSuperPatterns().isEmpty()) {
			return Optional.of(editorPattern);
		}

		GTFlattener flattener = new GTFlattener(editorPattern);
		if (flattener.hasErrors()) {
			return Optional.empty();
		} else {
			return Optional.of(flattener.getFlattenedPattern());
		}
	}
	
	private List<EditorNode> getNodesByOperator(final EditorPattern editorPattern,
			final EditorOperator... operators) {
		Objects.requireNonNull(editorPattern, "The editor pattern must not be null!");
		List<EditorOperator> operatorsList = Arrays.asList(operators);
		return editorPattern.getNodes().stream() //
				.filter(n -> operatorsList.contains(n.getOperator()))
				.sorted((a, b) -> a.getName().compareTo(b.getName())) //
				.collect(Collectors.toList());
	}
	
	/**
	 * goes recursively through all the conditions inside a editorCondition and finds all the patterns
	 * @return a list with all the patterns inside a condition
	 */
	private List<EditorPattern> getConditionPatterns(final EditorCondition condition) {
		List<EditorPattern> conditionPatterns = new ArrayList<EditorPattern>();
		for(EditorSimpleCondition simpleCondition: condition.getConditions()) {
			if(simpleCondition instanceof EditorConditionReference) {
				conditionPatterns.addAll(getConditionPatterns(((EditorConditionReference) simpleCondition).getCondition()));
			}
			else if(simpleCondition instanceof EditorApplicationCondition) {
				conditionPatterns.add(getFlattenedPattern(((EditorApplicationCondition) simpleCondition).getPattern()).get());
			}
		}
		return conditionPatterns;
	}
	
	public boolean isDisjoint() {
		return isDisjoint;
	}
	
	public List<Set<EditorNode>> getSubpatterns(){
		return currentSubgraphs;
	}
	/**
	 * Helper class to save multiple values under the same key in the graph map
	 */
	public class Pair<K, V>{
		K left;
		V right;
		
		public Pair(K left, V right){
			this.left = left;
			this.right = right;
		}
		public K getLeft() {
			return left;
		}
		public V getRight() {
			return right;
		}
		public void setLeft(K newLeft) {
			left = newLeft;
		}
		public void setRight(V newRight) {
			right = newRight;
		}
	}
}
