/*
 * generated by Xtext 2.14.0
 */
package org.emoflon.ibex.tgg.weights.scoping

import language.TGG
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.ContentHandler
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.scoping.Scopes
import org.emoflon.ibex.tgg.weights.weightDefinition.RuleWeightDefinition
import org.emoflon.ibex.tgg.weights.weightDefinition.WeightDefinitionFile
import org.emoflon.ibex.tgg.weights.weightDefinition.WeightDefinitionPackage
import java.util.LinkedList

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class WeightDefinitionScopeProvider extends AbstractWeightDefinitionScopeProvider {

	/**
	 * Cached imported resource
	 */
	var Resource importedTGG

	override getScope(EObject context, EReference reference) {
		if (isRuleWeightDefinition(context, reference)) {
			return getScopeForRuleWeightDefinition(context, reference)
		}
		return super.getScope(context, reference)
	}

	/**
	 * Checks if the requested scope is the rule reference
	 */
	def isRuleWeightDefinition(EObject context, EReference reference) {
		return context instanceof RuleWeightDefinition &&
			reference == WeightDefinitionPackage.Literals.RULE_WEIGHT_DEFINITION__RULE
	}

	/**
	 * Generates the scope for rule references by checking which rules exist in the imported TGG
	 */
	def getScopeForRuleWeightDefinition(EObject context, EReference reference) {
		try {
			val importUri = (context.eContainer as WeightDefinitionFile).importedTgg?.importURI
			val uri = URI.createURI(importUri);
			val resolvedUri = uri.resolve(URI.createPlatformResourceURI("/", true))
			if ((importedTGG === null) || (importedTGG.URI != resolvedUri)) {
				importedTGG = new ResourceSetImpl().createResource(resolvedUri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
				importedTGG.load(null);
				EcoreUtil.resolveAll(importedTGG);
			}
		} catch (Exception e) {
			// could not load resource
			return Scopes.scopeFor(new LinkedList)
		}
		
		return Scopes.scopeFor(
			importedTGG.contents
				.filter[it instanceof TGG]
				.flatMap[(it as TGG).rules]
				.filter[!it.abstract]
				.toList
		);
	}
}