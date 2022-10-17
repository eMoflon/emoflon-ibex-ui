package org.emoflon.ibex.tgg.tggl.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;

public class HierarchyManager<T extends EObject> {

	private Map<EObject, Collection<T>> obj2parents = new HashMap<>();
	private Collection<T> elements;

	public HierarchyManager(T root, Function<T, Collection<T>> traverser) {
		elements = traverse(root, traverser);
	}
	
	private Collection<T> traverse(T root, Function<T, Collection<T>> traverser) {
		var list = new LinkedList<T>();
		for(var subElement : traverser.apply(root)) {
			list.addAll(traverse(subElement, traverser));
		}
		obj2parents.put(root, list);
		list.add(root);
		return list;
	}
	
	public Collection<T> getHierarchyElements() {
		return elements;
	}
	
	public Collection<T> getParents(T obj) {
		return obj2parents.get(obj);
	}
	
	
}