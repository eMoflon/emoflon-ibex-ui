package org.emoflon.ibex.tgg.tggl.scoping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReferenceAlias;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.tgg.tggl.tGGL.AttributeConditionDefinition;
import org.emoflon.ibex.tgg.tggl.tGGL.AttributeConditionDefinitionLibrary;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinement;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementAliased;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;

public class TGGLFQAttributeConditionScope extends SimpleScope {

	public TGGLFQAttributeConditionScope(Collection<? extends EObject> objects) {
		super(Scopes.scopedElementsFor(objects, new FQNRootPackageQualifiedNameProvider()));
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final EObject object) {
		Iterable<IEObjectDescription> defaultImpl = super.getElements(object);
		if (defaultImpl.iterator().hasNext())
			return defaultImpl;

		// If default does not work, try using the exact URI of object (no normalization etc)
		Iterable<IEObjectDescription> localElements = getLocalElementsByEObject(object, EcoreUtil.getURI(object));
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(object);
			}
		});
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}

}

class FQNRootPackageQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof AttributeConditionDefinition definition) {
			var library = SlimGTModelUtil.getContainer(obj, AttributeConditionDefinitionLibrary.class);
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(library.getName() + "." + definition.getName());
		}
		return super.getFullyQualifiedName(obj);
	}
}