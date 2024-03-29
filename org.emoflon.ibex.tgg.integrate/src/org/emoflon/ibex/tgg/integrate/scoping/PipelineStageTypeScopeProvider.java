package org.emoflon.ibex.tgg.integrate.scoping;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.emoflon.ibex.tgg.editor.tgg.Schema;
import org.emoflon.ibex.tgg.editor.tgg.TripleGraphGrammarFile;
import org.emoflon.ibex.tgg.integrate.integrate.Import;
import org.emoflon.ibex.tgg.integrate.integrate.Integrate;
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType;

public class PipelineStageTypeScopeProvider {

	public IScope provide(PipelineStageType context) {
		Integrate integrate = EcoreUtil2.getContainerOfType(context, Integrate.class);
		return buildScopeFromImports(integrate.getImports());
	}

	private IScope buildScopeFromImports(EList<Import> imports) {
		Set<EClass> types = imports.stream().map(Import::getSchema)
				.flatMap(this::getURIStream)
				.map(this::getResourceForURI)
				.map(this::getEPackage)
				.flatMap(this::getClassifierStream)
				.collect(Collectors.toSet());

		return new SimpleScope(Scopes.scopeFor(types),
				Scopes.scopedElementsFor(types, new DefaultDeclarativeQualifiedNameProvider()));
	}

	private Stream<URI> getURIStream(Schema schema) {
		TripleGraphGrammarFile tggFile = EcoreUtil2.getContainerOfType(schema, TripleGraphGrammarFile.class);
		return tggFile.getImports().stream().map(imp -> URI.createURI(imp.getName()));
	}
	
	private Resource getResourceForURI(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(uri, true);
	}
	
	private EPackage getEPackage(Resource resource) {
		return (EPackage) resource.getContents().get(0);
	}
	
	private Stream<EClass> getClassifierStream(EPackage pkg) {
		return EcoreUtil2.getAllContentsOfType(pkg, EClass.class).stream();
	}
}
