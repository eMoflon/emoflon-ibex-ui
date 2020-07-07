package org.emoflon.ibex.tgg.integrate.scoping;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.emoflon.ibex.tgg.integrate.integrate.Import;
import org.emoflon.ibex.tgg.integrate.integrate.Integrate;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineTypeFilterStage;

public class PipelineTypeFilterScopeProvider {

	public IScope provide(EObject context) {
		PipelineTypeFilterStage stage = (PipelineTypeFilterStage) context;
		Integrate integrate = getIntegrate(stage);
		return buildScopeFromImports(integrate.getImports());
	}
	

	private Integrate getIntegrate(PipelineTypeFilterStage stage) {
		return (Integrate) stage.eContainer().eContainer().eContainer().eContainer();
	}

	private IScope buildScopeFromImports(EList<Import> imports) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Set<EClassifier> types = imports.stream().map(imp -> URI.createURI(imp.getName())).map(uri -> resourceSet.getResource(uri, true))
				.map(resource -> (EPackage) resource.getContents().get(0))
				.flatMap(pkg -> EcoreUtil2.getAllContentsOfType(pkg, EClassifier.class).stream())
				.collect(Collectors.toSet());
		
		return new SimpleScope(
				Scopes.scopeFor(types), 
				Scopes.scopedElementsFor(types, new DefaultDeclarativeQualifiedNameProvider()));
	}
}
