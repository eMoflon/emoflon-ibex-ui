package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emoflon.ibex.tgg.ui.debug.api.Attribute;
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

	public static EObjectAdapter adapt(EObject eObject, Domain domain) {
		if (!wrappers.containsKey(eObject))
			wrappers.put(eObject, new EObjectAdapter(eObject, domain));
		return wrappers.get(eObject);
	}

	// ----------

	private EObject object;

	private String label;
	private String index;
	private Domain domain;
	private List<Attribute> attributes;

	private EObjectAdapter(EObject eObject, Domain domain) {
		object = eObject;
		this.domain = domain;

		label = eObject.eContainingFeature() != null ? object.eContainingFeature().getName() : "root";

		if (eObject.eContainer() == null) {
			Resource resource = eObject.eResource();
			index = resource.getResourceSet().getResources().indexOf(resource) + "_"
					+ resource.getContents().indexOf(eObject);
		} else {
			EObject container = eObject.eContainer();
			index = EObjectAdapter.adapt(container, domain).getIndex() + "_" + container.eContents().indexOf(eObject);
		}

		attributes = new ArrayList<>();
		for (EAttribute attr : object.eClass().getEAllAttributes()) {
			if(EcorePackage.eINSTANCE.getEClassifiers().contains(attr.eClass())) {
				attributes.add(EAttributeAdapter.adapt(object, attr));
			}
//			attributes.add(attr.getEType().getName() + " " + attr.getName() + " = " + object.eGet(attr));
		}
			
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
		return Action.CONTEXT;
	}

	@Override
	public List<Attribute> getAttributes() {
		return attributes;
	}

	public static void constructGraphDomain(GraphBuilder builder, Domain domain, Collection<EObject> domainObjects) {
		for (EObject domObject : domainObjects) {
			builder.addNode(EObjectAdapter.adapt(domObject, domain));
			for (EObject contentObject : domObject.eContents()) {
				builder.addEdge(contentObject.eContainingFeature().getName(), EObjectAdapter.get(domObject),
						EObjectAdapter.adapt(contentObject, domain), EdgeType.NORMAL, Action.CONTEXT);
			}
			for (EReference reference : domObject.eClass().getEAllReferences()) {
				if(reference.isContainment() || reference.isContainer()) {
					continue; //allready handled in the first loop
				}
				Object referencedObject = domObject.eGet(reference, true);
				if(referencedObject == null) {
					continue;
				}
				if(referencedObject instanceof EList) {
					for(EObject ref : ((EList<EObject>) referencedObject)) {
						builder.addEdge(reference.getName(), EObjectAdapter.get(domObject),
								EObjectAdapter.adapt(ref, domain), EdgeType.NORMAL, Action.CONTEXT);
					}
				} else {
					EObject ref = (EObject) referencedObject;
					builder.addEdge(reference.getName(), EObjectAdapter.get(domObject),
							EObjectAdapter.adapt(ref, domain), EdgeType.NORMAL, Action.CONTEXT);
				}
			}
//			for (EObject crossReference : object.eCrossReferences()) {
//				builder.addEdge(crossReference.eContainingFeature().getName(), EObjectAdapter.get(object),
//						EObjectAdapter.adapt(crossReference, domain), EdgeType.NORMAL, Action.CONTEXT);
//			}
		}
	}

	public static void constructCorrEdges(GraphBuilder builder, Collection<EObject> corrObjects) {
		for (EObject corrObject : corrObjects) {
			builder.addEdge(":" + corrObject.eClass().getName(), //
					EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("source")),
							Domain.SRC), //
					EObjectAdapter.adapt((EObject) corrObject.eGet(corrObject.eClass().getEStructuralFeature("target")),
							Domain.TRG), //
					EdgeType.CORR, //
					Action.CONTEXT);
		}
	}
}
