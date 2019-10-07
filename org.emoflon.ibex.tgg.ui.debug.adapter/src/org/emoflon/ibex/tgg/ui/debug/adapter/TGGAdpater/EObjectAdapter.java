package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdpater;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Domain;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.api.impl.GraphBuilder;

public class EObjectAdapter implements Node {

	private static Map<EObject, EObjectAdapter> wrappers = new HashMap<>();

	public static EObjectAdapter get(EObject eObject) {
		return wrappers.get(eObject);
	}

	public static EObjectAdapter adapt(EObject eObject, Domain domain, Action action) {
		if (!wrappers.containsKey(eObject))
			wrappers.put(eObject, new EObjectAdapter(eObject, domain, action));
		return wrappers.get(eObject);
	}

	// ----------

	private EObject object;

	private String label;
	private String index;
	private Domain domain;
	private Action action;
	private List<String> attributes;

	private EObjectAdapter(EObject eObject, Domain domain, Action action) {
		object = eObject;
		this.domain = domain;
		this.action = action;

		label = eObject.eContainingFeature() != null ? object.eContainingFeature().getName() : "root";

		if (eObject.eContainer() == null) {
			Resource resource = eObject.eResource();
			index = resource.getResourceSet().getResources().indexOf(resource) + "_"
					+ resource.getContents().indexOf(eObject);
		} else {
			EObject container = eObject.eContainer();
			index = EObjectAdapter.adapt(container, domain, Action.CONTEXT).getIndex() + "_" + container.eContents().indexOf(eObject);
		}

		attributes = new ArrayList<>();
		for (EAttribute attr : object.eClass().getEAttributes())
			attributes.add(attr.getEType().getName() + " " + attr.getName() + " = " + object.eGet(attr));
	}

	public String getIndex() {
		return index;
	}

	@Override
	public String getType() {
		return object.eClass().getName();
	}

	@Override
	public String getName() {
		return label + "_" + index + " : " + object.eClass().getName();
	}

	@Override
	public Domain getDomain() {
		return domain;
	}

	@Override
	public Action getAction() {
		return action;
	}

	@Override
	public List<String> getAttributes() {
		return attributes;
	}

	public void setAction(Action pAction) {
		action = pAction;
	}

	public static void constructGraphDomain(GraphBuilder builder, Domain domain, Collection<EObject> domainObjects) {
		for (EObject object : domainObjects) {
			builder.addNode(EObjectAdapter.adapt(object, domain, Action.CONTEXT));
			for (EObject contentObject : object.eContents()) {
				builder.addEdge(contentObject.eContainingFeature().getName(), EObjectAdapter.get(object),
						EObjectAdapter.adapt(contentObject, domain, Action.CONTEXT), EdgeType.NORMAL, Action.CONTEXT);
			}
			for (EObject crossReference : object.eCrossReferences()) {
				builder.addEdge(crossReference.eContainingFeature().getName(), EObjectAdapter.get(object),
						EObjectAdapter.adapt(crossReference, domain, Action.CONTEXT), EdgeType.NORMAL, Action.CONTEXT);
			}
		}
	}

	public static void constructGraphDomain(GraphBuilder builder, Domain domain, Collection<EObject> domainObjects, TGGRuleAdapter rule) {
		for (EObject object : domainObjects) {
			EObjectAdapter src = EObjectAdapter.adapt(object, domain, Action.CONTEXT);
			Optional<TGGRuleNodeAdapter> srcn = rule.getNodes().stream().filter(n -> n.getType().equals(src.getType()) && n.getDomain().equals(src.getDomain())).findFirst();
			if (srcn.isPresent()) {
				src.setAction(srcn.get().getAction());
			}
			builder.addNode(src);
			for (EObject contentObject : object.eContents()) {
				EObjectAdapter trg = EObjectAdapter.adapt(contentObject, domain, Action.CONTEXT);
				Optional<TGGRuleNodeAdapter> trgn = rule.getNodes().stream().filter(n -> n.getType().equals(trg.getType()) && n.getDomain().equals(trg.getDomain())).findFirst();

				Action action = Action.CONTEXT;
				EdgeType edgeType = EdgeType.NORMAL;

				if (trgn.isPresent()) {
					trg.setAction(trgn.get().getAction());
					
					if (srcn.isPresent()) {
						Optional<Edge> edge = rule.getGraph().getEdges().stream().filter(e ->
							!e.getType().equals(EdgeType.CORR) &&
							e.getSrcNode().equals(srcn.get()) &&
							e.getTrgNode().equals(trgn.get()))
						.findFirst();
						
						if (edge.isPresent()) {
							action = edge.get().getAction(); 
							edgeType = edge.get().getType();
						}
					}
				}
				 
				builder.addEdge(contentObject.eContainingFeature().getName(), src, trg, edgeType, action);
			}
			for (EObject crossReference : object.eCrossReferences()) {
				EObjectAdapter trg = EObjectAdapter.adapt(crossReference, domain, Action.CONTEXT);
				Optional<TGGRuleNodeAdapter> trgn = rule.getNodes().stream().filter(n -> n.getType().equals(trg.getType()) && n.getDomain().equals(trg.getDomain())).findFirst();

				Action action = Action.CONTEXT;
				EdgeType edgeType = EdgeType.NORMAL;

				if (trgn.isPresent()) {
					trg.setAction(trgn.get().getAction());
					
					if (srcn.isPresent()) {
						Optional<Edge> edge = rule.getGraph().getEdges().stream().filter(e ->
							!e.getType().equals(EdgeType.CORR) &&
							e.getSrcNode().equals(srcn.get()) &&
							e.getTrgNode().equals(trgn.get()))
						.findFirst();
						
						if (edge.isPresent()) {
							action = edge.get().getAction(); 
							edgeType = edge.get().getType();
						}
					}
				}
				
				builder.addEdge(crossReference.eContainingFeature().getName(), src, trg, edgeType, action);
			}
		}
	}	
	
	public static void constructCorrEdges(GraphBuilder builder, Collection<EObject> corrObjects) {
		for (EObject corrObject : corrObjects) {
			builder.addEdge(":" + corrObject.eClass().getName(), //
					EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("source")),
							Domain.SRC, Action.CONTEXT), //
					EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("target")),
							Domain.TRG, Action.CONTEXT), //
					EdgeType.CORR, //
					Action.CONTEXT);
		}
	}
	
	public static void constructCorrEdges(GraphBuilder builder, Collection<EObject> corrObjects, TGGRuleAdapter rule) {
		for (EObject corrObject : corrObjects) {
			Action action = Action.CONTEXT;
			EdgeType edgeType = EdgeType.NORMAL;
			
			EObjectAdapter src = EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("source")), Domain.SRC, Action.CONTEXT);
			EObjectAdapter trg = EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("target")),
					Domain.TRG, Action.CONTEXT);
			
			Optional<TGGRuleNodeAdapter> srcn = rule.getNodes().stream().filter(n -> n.getType().equals(src.getType()) && n.getDomain().equals(src.getDomain())).findFirst();
			if (srcn.isPresent()) {
				src.setAction(srcn.get().getAction());
			}
			
			Optional<TGGRuleNodeAdapter> trgn = rule.getNodes().stream().filter(n -> n.getType().equals(trg.getType()) && n.getDomain().equals(trg.getDomain())).findFirst();
			if (trgn.isPresent()) {
				trg.setAction(trgn.get().getAction());
			}
			
			if (srcn.isPresent() && trgn.isPresent()) {
				Optional<Edge> edge = rule.getGraph().getEdges().stream().filter(e ->
					e.getType().equals(EdgeType.CORR) &&
					e.getSrcNode().equals(srcn.get()) &&
					e.getTrgNode().equals(trgn.get()))
				.findFirst();
			
				if (edge.isPresent()) {
					action = edge.get().getAction(); 
					edgeType = edge.get().getType();
				}
			}
			
			builder.addEdge(":" + corrObject.eClass().getName(), src, trg, edgeType, action);
		}
	}	
}
