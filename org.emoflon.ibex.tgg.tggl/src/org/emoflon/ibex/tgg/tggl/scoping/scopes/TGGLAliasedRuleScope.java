package org.emoflon.ibex.tgg.tggl.scoping.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;
import org.emoflon.ibex.common.slimgt.util.SlimGTModelUtil;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGCorrespondenceNode;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGLRuleRefinementAliased;
import org.emoflon.ibex.tgg.tggl.tGGL.TGGRule;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;

public class TGGLAliasedRuleScope extends SimpleScope {

	public TGGLAliasedRuleScope(Collection<TGGLRuleRefinementAliased> ruleRefinementAliases, Map<TGGRule, Collection<EObject>> rule2refinedNodes) {
		super(calculcateScopes(ruleRefinementAliases, rule2refinedNodes));
	}
	
	private static Iterable<IEObjectDescription> calculcateScopes(Collection<TGGLRuleRefinementAliased> ruleRefinementAliases, Map<TGGRule, Collection<EObject>> rule2refinedNodes) {
		Map<String, String> ruleName2alias = new HashMap<>();

		for(var alias : ruleRefinementAliases) {
			ruleName2alias.put(alias.getSuperRule().getName(), alias.getName());
		}
		
		Collection<IEObjectDescription> scopes = new LinkedList<>();
		for(var rule : rule2refinedNodes.keySet()) {
			if(ruleName2alias.containsKey(rule.getName())) {
				var aliasName = ruleName2alias.get(rule.getName());
				var iterable = Scopes.scopedElementsFor(rule2refinedNodes.get(rule), new RuleAliasedNamedProvider(aliasName));
				iterable.forEach(scopes::add);
			}
			var iterable = Scopes.scopedElementsFor(rule2refinedNodes.get(rule), new RuleAwareQualifiedNamedProvider(rule));
			iterable.forEach(scopes::add);
			
		}
		return scopes;
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

class RuleAliasedNamedProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	private String aliasName;
	
	public RuleAliasedNamedProvider(String aliasName) {
		this.aliasName = aliasName;
	}
	
	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		
		if(obj instanceof SlimRuleNode node) {
			var tggRule = SlimGTModelUtil.getContainer(obj, TGGRule.class);
			if(tggRule == null)
				return super.getFullyQualifiedName(obj);
			
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(aliasName + "." + node.getName());
		}
		
		if(obj instanceof TGGCorrespondenceNode corrNode) {
			var tggRule = SlimGTModelUtil.getContainer(obj, TGGRule.class);
			if(tggRule == null)
				return super.getFullyQualifiedName(obj);
			
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(aliasName + "." + corrNode.getName());
		}
		
		return super.getFullyQualifiedName(obj);
	}
}

class RuleAwareQualifiedNamedProvider extends DefaultDeclarativeQualifiedNameProvider {

	private TGGRule rule;
	
	public RuleAwareQualifiedNamedProvider(TGGRule rule) {
		this.rule = rule;
	}
	
	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		var tggRule = rule;
		if(obj instanceof SlimRuleNode node) {
			if(tggRule == null)
				tggRule = SlimGTModelUtil.getContainer(obj, TGGRule.class);
			if(tggRule == null)
				return super.getFullyQualifiedName(obj);
			
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(tggRule.getName() + "." + node.getName());
		}
		if(obj instanceof TGGCorrespondenceNode corrNode) {
			if(tggRule == null)
				tggRule = SlimGTModelUtil.getContainer(obj, TGGRule.class);
			if(tggRule == null)
				return super.getFullyQualifiedName(obj);
			
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(tggRule.getName() + "." + corrNode.getName());
		}
		
		return super.getFullyQualifiedName(obj);
	}
}