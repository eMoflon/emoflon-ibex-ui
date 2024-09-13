package org.emoflon.ibex.tgg.tggl.scoping.scopes;

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
import org.emoflon.ibex.common.slimgt.slimGT.GTLRuleRefinementAliased;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReferenceAlias;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.tgg.tggl.tGGL.SlimRule;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinement;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementAliased;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;

public class TGGLAliasedPatternScope extends SimpleScope {

	public TGGLAliasedPatternScope(Collection<GTLRuleRefinementAliased> ruleRefinementAliases, Collection<? extends EObject> objects) {
		super(new SimpleScope(Scopes.scopedElementsFor(objects, new PatternAliasedNamedProvider(ruleRefinementAliases))),
				Scopes.scopedElementsFor(objects, new PatternAwareQualifiedNamedProvider()));
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

class PatternAliasedNamedProvider extends DefaultDeclarativeQualifiedNameProvider {

	private Map<String, String> ruleName2alias = new HashMap<>();
	
	public PatternAliasedNamedProvider(Collection<GTLRuleRefinementAliased> aliases) {
		for(var alias : aliases) {
			ruleName2alias.put(((SlimRule) alias.getSuperRule()).getName(), alias.getName());
		}
	}
	
	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		
		if(obj instanceof SlimRuleNode node) {
			var pattern = SlimGTModelUtil.getContainer(obj, SlimRule.class);
			if(pattern == null)
				return super.getFullyQualifiedName(obj);
			
			if(!ruleName2alias.containsKey(pattern.getName()))
				return super.getFullyQualifiedName(obj);
			
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(ruleName2alias.get(pattern.getName()) + "." + node.getName());
		}
		
		return super.getFullyQualifiedName(obj);
	}
}

class PatternAwareQualifiedNamedProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if(obj instanceof SlimRuleNode node) {
			var pattern = SlimGTModelUtil.getContainer(obj, SlimRule.class);
			if(pattern == null)
				return super.getFullyQualifiedName(obj);
			
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(pattern.getName() + "." + node.getName());
		}
		
		return super.getFullyQualifiedName(obj);
	}
}