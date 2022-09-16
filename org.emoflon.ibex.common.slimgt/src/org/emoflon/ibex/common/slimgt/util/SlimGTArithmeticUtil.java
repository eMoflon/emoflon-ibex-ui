package org.emoflon.ibex.common.slimgt.util;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.emoflon.ibex.common.slimgt.slimGT.ArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ArithmeticLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.BooleanLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.BracketExpression;
import org.emoflon.ibex.common.slimgt.slimGT.Constant;
import org.emoflon.ibex.common.slimgt.slimGT.ConstantLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.CountExpression;
import org.emoflon.ibex.common.slimgt.slimGT.DoubleLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.EnumExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ExpArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ExpressionOperand;
import org.emoflon.ibex.common.slimgt.slimGT.IntegerLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.MinMaxArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ProductArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.StochasticArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.StringLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.SumArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.UnaryArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ValueExpression;
import org.emoflon.ibex.common.slimgt.validation.DataTypeParseResult;
import org.emoflon.ibex.common.slimgt.validation.ValueExpressionDataType;

public final class SlimGTArithmeticUtil {

	public static DataTypeParseResult parseDataType(ValueExpression expression) throws UnsupportedOperationException {
		return parseDataType((ArithmeticExpression) expression);
	}

	public static DataTypeParseResult parseDataType(ArithmeticExpression expression)
			throws UnsupportedOperationException {
		if (expression instanceof SumArithmeticExpression sum) {
			DataTypeParseResult lhs = parseDataType(sum.getLeft());
			DataTypeParseResult rhs = parseDataType(sum.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, sum,
					List.of(SlimGTPackage.Literals.SUM_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.SUM_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof ProductArithmeticExpression prod) {
			DataTypeParseResult lhs = parseDataType(prod.getLeft());
			DataTypeParseResult rhs = parseDataType(prod.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, prod,
					List.of(SlimGTPackage.Literals.PRODUCT_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.PRODUCT_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof ExpArithmeticExpression exp) {
			DataTypeParseResult lhs = parseDataType(exp.getLeft());
			DataTypeParseResult rhs = parseDataType(exp.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, exp,
					List.of(SlimGTPackage.Literals.EXP_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.EXP_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof StochasticArithmeticExpression stoc) {
			DataTypeParseResult lhs = parseDataType(stoc.getMean());
			if (stoc.isHasSd()) {
				DataTypeParseResult rhs = parseDataType(stoc.getSd());
				return DataTypeParseResult.mergeResult(lhs, rhs, stoc,
						List.of(SlimGTPackage.Literals.STOCHASTIC_ARITHMETIC_EXPRESSION__MEAN,
								SlimGTPackage.Literals.STOCHASTIC_ARITHMETIC_EXPRESSION__SD));
			} else {
				return lhs;
			}

		} else if (expression instanceof MinMaxArithmeticExpression minMax) {
			DataTypeParseResult lhs = parseDataType(minMax.getLeft());
			DataTypeParseResult rhs = parseDataType(minMax.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, minMax,
					List.of(SlimGTPackage.Literals.MIN_MAX_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.MIN_MAX_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof UnaryArithmeticExpression un) {
			return parseDataType(un.getOperand());
		} else if (expression instanceof BracketExpression brack) {
			return parseDataType(brack.getOperand());
		} else if (expression instanceof ExpressionOperand op) {
			if (op.getOperand() instanceof NodeAttributeExpression nae) {
				return attributeToParseResult(nae, SlimGTPackage.Literals.NODE_ATTRIBUTE_EXPRESSION__FEATURE,
						nae.getFeature());
			} else if (op.getOperand() instanceof CountExpression count) {
				return new DataTypeParseResult(ValueExpressionDataType.INTEGER);
			} else if (op.getOperand() instanceof ArithmeticLiteral lit) {
				if (lit.getValue() instanceof DoubleLiteral) {
					return new DataTypeParseResult(ValueExpressionDataType.DOUBLE);
				} else if (lit.getValue() instanceof IntegerLiteral) {
					return new DataTypeParseResult(ValueExpressionDataType.INTEGER);
				} else if (lit.getValue() instanceof StringLiteral) {
					return new DataTypeParseResult(ValueExpressionDataType.STRING);
				} else if (lit.getValue() instanceof BooleanLiteral) {
					return new DataTypeParseResult(ValueExpressionDataType.BOOLEAN);
				} else {
					throw new UnsupportedOperationException("Unkown arithmetic literal type: " + lit.getValue());
				}
			} else if (op.getOperand() instanceof EnumExpression en) {
				return new DataTypeParseResult(ValueExpressionDataType.ENUM);
			} else if (op.getOperand() instanceof Constant con) {
				if (con.getValue() == ConstantLiteral.E || con.getValue() == ConstantLiteral.PI) {
					return new DataTypeParseResult(ValueExpressionDataType.DOUBLE);
				} else if (con.getValue() == ConstantLiteral.NULL) {
					return new DataTypeParseResult(ValueExpressionDataType.NULL);
				} else {
					throw new UnsupportedOperationException("Unkown arithmetic constant: " + con.getValue());
				}
			} else {
				throw new UnsupportedOperationException("Unkown arithmetic operand type: " + op.getOperand());
			}
		} else {
			throw new UnsupportedOperationException("Unkown arithmetic operation type: " + expression);
		}
	}

	public static DataTypeParseResult attributeToParseResult(EObject context, EStructuralFeature location,
			EAttribute attribute) {
		return typeToParseResult(context, location, attribute.getEType());
	}

	public static DataTypeParseResult typeToParseResult(EObject context, EStructuralFeature location,
			EClassifier dataType) {
		if (dataType == EcorePackage.Literals.EBYTE || dataType == EcorePackage.Literals.ESHORT
				|| dataType == EcorePackage.Literals.EINT || dataType == EcorePackage.Literals.ELONG) {
			return new DataTypeParseResult(ValueExpressionDataType.INTEGER);
		} else if (dataType == EcorePackage.Literals.EFLOAT || dataType == EcorePackage.Literals.EDOUBLE) {
			return new DataTypeParseResult(ValueExpressionDataType.DOUBLE);
		} else if (dataType == EcorePackage.Literals.ESTRING) {
			return new DataTypeParseResult(ValueExpressionDataType.STRING);
		} else if (dataType == EcorePackage.Literals.EENUM || dataType == EcorePackage.Literals.EENUM_LITERAL
				|| dataType == EcorePackage.Literals.EENUMERATOR) {
			return new DataTypeParseResult(ValueExpressionDataType.ENUM);
		} else if (dataType == EcorePackage.Literals.EBOOLEAN) {
			return new DataTypeParseResult(ValueExpressionDataType.BOOLEAN);
		} else if (dataType == EcorePackage.Literals.EDATE) {
			return new DataTypeParseResult(ValueExpressionDataType.DATE);
		} else {
			return new DataTypeParseResult(ValueExpressionDataType.UNSUPPORTED, context, location);
		}
	}
}
