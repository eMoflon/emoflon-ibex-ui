package org.emoflon.ibex.tgg.weights.scoping

import com.google.inject.Inject
import language.TGGRuleCorr
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.emoflon.ibex.tgg.weights.weightDefinition.RuleWeightDefinition
import org.emoflon.ibex.tgg.weights.weightDefinition.WeightCalculation

class TggWeightTypeComputer extends XbaseTypeComputer {
	@Inject extension JvmTypesBuilder

	override computeTypes(XExpression expression, ITypeComputationState state) {
//		println(expression)
		if (expression instanceof WeightCalculation)
			_computeTypes(expression, state)
		else
			super.computeTypes(expression, state)
	}

	def _computeTypes(WeightCalculation calc, ITypeComputationState state) {
//		println("WeightCalcExpr:" + calc)
		val expression = calc.calc
		val ruleNodes = (calc.eContainer as RuleWeightDefinition).rule.nodes
		for (node : ruleNodes.filter[!(it instanceof TGGRuleCorr)]) {
			val v = XbaseFactory.eINSTANCE.createXVariableDeclaration => [
				writeable = false
				name = node.name
			]
			expression.eResource.contents += v
			state.assignType(v, getTypeForName(EObject, state))
		}
//		state.withinScope(calc);
//		//inner expression
//		val expressionState = state.withoutExpectation(); 
//		expressionState.computeTypes(expression);
//		addLocalToCurrentScope(expression, state);
		super.computeTypes(expression, state)
	}
//		state.acceptActualType(getTypeForName(double, state))
//		val ruleNodes = (calc.eContainer as RuleWeightDefinition).name.nodes
//		for(node : ruleNodes.filter[!(it instanceof TGGRuleCorr)]) {
//			val v = XbaseFactory.eINSTANCE.createXVariableDeclaration => [
//				writeable = false
//				name = node.name
//			]
//			calc.eResource.contents += v
//			state.assignType(v, getTypeForName(EObject, state))
//		}
//		state.withinScope(calc);
//		val expression = calc.calc
//		val expressionState = state.withExpectation(getTypeForName(double, state))
//		expressionState.computeTypes(expression);
//		addLocalToCurrentScope(expression, state);
//		super.computeTypes(calc, state)
//	}
//	def dispatch computeTypes(WeightCalculation calc, ITypeComputationState state) {
//		println("WeightCalcExpr:"+calc)
//		state.acceptActualType(getTypeForName(double, state))
//		val ruleNodes = (calc.eContainer as RuleWeightDefinition).name.nodes
//		for(node : ruleNodes.filter[!(it instanceof TGGRuleCorr)]) {
//			val v = XbaseFactory.eINSTANCE.createXVariableDeclaration => [
//				writeable = false
//				name = node.name
//			]
//			calc.eResource.contents += v
//			state.assignType(v, getTypeForName(EObject, state))
//		}
//		state.withinScope(calc);
//		var expressionState = state.withExpectation(getTypeForName(double, state))
//		val expression = calc.calc
//		expressionState.computeTypes(expression);
//		addLocalToCurrentScope(expression, state);
//		for (ITypeExpectation expectation: state.getExpectations()) {
//			val expectedType = expectation.getExpectedType();
//			if (expectedType != null && expectedType.isPrimitiveVoid()) {
//				expressionState = state.withoutExpectation(); // no expectation
//				expressionState.computeTypes(expression);
//				addLocalToCurrentScope(expression, state);
//				expectation.acceptActualType(getPrimitiveVoid(state), ConformanceFlags.CHECKED_SUCCESS);
//			} else {
//				state.computeTypes(expression);
//				// add the last expression to the scope, too in order validate for duplicate names, even
//				// though the variable declaration could be removed automatically to keep only the side effect
//				// of the initializer
//				addLocalToCurrentScope(expression, state);
//			}
//		}
//	}
}
