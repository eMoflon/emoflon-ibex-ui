package org.emoflon.ibex.gt.gtl.util;

import java.util.List;
import java.util.Set;

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
import org.emoflon.ibex.common.slimgt.slimGT.IntegerLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.MinMaxArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeAttributeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.NodeExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ProductArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.SlimGTPackage;
import org.emoflon.ibex.common.slimgt.slimGT.StochasticArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.StringLiteral;
import org.emoflon.ibex.common.slimgt.slimGT.SumArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.UnaryArithmeticExpression;
import org.emoflon.ibex.common.slimgt.slimGT.ValueExpression;
import org.emoflon.ibex.common.slimgt.util.SlimGTArithmeticUtil;
import org.emoflon.ibex.common.slimgt.validation.DataTypeParseResult;
import org.emoflon.ibex.common.slimgt.validation.ValueExpressionDataType;
import org.emoflon.ibex.gt.gtl.gTL.ExpressionOperand;
import org.emoflon.ibex.gt.gtl.gTL.GTLIteratorAttributeExpression;
import org.emoflon.ibex.gt.gtl.gTL.GTLPackage;
import org.emoflon.ibex.gt.gtl.gTL.GTLParameterExpression;

public final class GTLArithmeticUtil {

	public static DataTypeParseResult parseDominantDataType(ValueExpression expression) throws Exception {
		return parseDominantDataType((ArithmeticExpression) expression);
	}

	public static DataTypeParseResult parseDominantDataType(ArithmeticExpression expression) throws Exception {
		if (expression instanceof SumArithmeticExpression sum) {
			DataTypeParseResult lhs = parseDominantDataType(sum.getLeft());
			DataTypeParseResult rhs = parseDominantDataType(sum.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, sum,
					List.of(SlimGTPackage.Literals.SUM_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.SUM_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof ProductArithmeticExpression prod) {
			DataTypeParseResult lhs = parseDominantDataType(prod.getLeft());
			DataTypeParseResult rhs = parseDominantDataType(prod.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, prod,
					List.of(SlimGTPackage.Literals.PRODUCT_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.PRODUCT_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof ExpArithmeticExpression exp) {
			DataTypeParseResult lhs = parseDominantDataType(exp.getLeft());
			DataTypeParseResult rhs = parseDominantDataType(exp.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, exp,
					List.of(SlimGTPackage.Literals.EXP_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.EXP_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof StochasticArithmeticExpression stoc) {
			DataTypeParseResult lhs = parseDominantDataType(stoc.getMean());
			if (stoc.isHasSd()) {
				DataTypeParseResult rhs = parseDominantDataType(stoc.getSd());
				return DataTypeParseResult.mergeResult(lhs, rhs, stoc,
						List.of(SlimGTPackage.Literals.STOCHASTIC_ARITHMETIC_EXPRESSION__MEAN,
								SlimGTPackage.Literals.STOCHASTIC_ARITHMETIC_EXPRESSION__SD));
			} else {
				return lhs;
			}

		} else if (expression instanceof MinMaxArithmeticExpression minMax) {
			DataTypeParseResult lhs = parseDominantDataType(minMax.getLeft());
			DataTypeParseResult rhs = parseDominantDataType(minMax.getRight());
			return DataTypeParseResult.mergeResult(lhs, rhs, minMax,
					List.of(SlimGTPackage.Literals.MIN_MAX_ARITHMETIC_EXPRESSION__LEFT,
							SlimGTPackage.Literals.MIN_MAX_ARITHMETIC_EXPRESSION__RIGHT));
		} else if (expression instanceof UnaryArithmeticExpression un) {
			return parseDominantDataType(un.getOperand());
		} else if (expression instanceof BracketExpression brack) {
			return parseDominantDataType(brack.getOperand());
		} else if (expression instanceof ExpressionOperand op) {
			if (op.getOperand() instanceof NodeExpression ne) {
				return SlimGTArithmeticUtil.typeToParseResult(ne, SlimGTPackage.Literals.NODE_EXPRESSION__NODE,
						EcorePackage.Literals.EOBJECT);
			} else if (op.getOperand() instanceof NodeAttributeExpression gae) {
				return SlimGTArithmeticUtil.attributeToParseResult(gae,
						SlimGTPackage.Literals.NODE_ATTRIBUTE_EXPRESSION__FEATURE, gae.getFeature());
			} else if (op.getOperand() instanceof GTLIteratorAttributeExpression ie) {
				return SlimGTArithmeticUtil.attributeToParseResult(ie,
						GTLPackage.Literals.GTL_ITERATOR_ATTRIBUTE_EXPRESSION__FEATURE, ie.getFeature());
			} else if (op.getOperand() instanceof GTLParameterExpression param) {
				return SlimGTArithmeticUtil.typeToParseResult(param,
						GTLPackage.Literals.GTL_PARAMETER_EXPRESSION__PARAMETER, param.getParameter().getType());
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

	public static void parseAllDataTypes(ArithmeticExpression expression, Set<ValueExpressionDataType> dataTypes)
			throws Exception {
		if (expression instanceof SumArithmeticExpression sum) {
			parseAllDataTypes(sum.getLeft(), dataTypes);
			parseAllDataTypes(sum.getRight(), dataTypes);
		} else if (expression instanceof ProductArithmeticExpression prod) {
			parseAllDataTypes(prod.getLeft(), dataTypes);
			parseAllDataTypes(prod.getRight(), dataTypes);
		} else if (expression instanceof ExpArithmeticExpression exp) {
			parseAllDataTypes(exp.getLeft(), dataTypes);
			parseAllDataTypes(exp.getRight(), dataTypes);
		} else if (expression instanceof StochasticArithmeticExpression stoc) {
			parseAllDataTypes(stoc.getMean(), dataTypes);
			if (stoc.isHasSd()) {
				parseAllDataTypes(stoc.getSd(), dataTypes);
			}
		} else if (expression instanceof MinMaxArithmeticExpression minMax) {
			parseAllDataTypes(minMax.getLeft(), dataTypes);
			parseAllDataTypes(minMax.getRight(), dataTypes);
		} else if (expression instanceof UnaryArithmeticExpression un) {
			parseAllDataTypes(un.getOperand(), dataTypes);
		} else if (expression instanceof BracketExpression brack) {
			parseAllDataTypes(brack.getOperand(), dataTypes);
		} else if (expression instanceof ExpressionOperand op) {
			if (op.getOperand() instanceof NodeExpression ne) {
				dataTypes.add(ValueExpressionDataType.OBJECT);
			} else if (op.getOperand() instanceof NodeAttributeExpression nae) {
				dataTypes.add(SlimGTArithmeticUtil.attributeToDataType(nae.getFeature()));
			} else if (op.getOperand() instanceof GTLIteratorAttributeExpression nae) {
				dataTypes.add(SlimGTArithmeticUtil.attributeToDataType(nae.getFeature()));
			} else if (op.getOperand() instanceof GTLParameterExpression param) {
				dataTypes.add(SlimGTArithmeticUtil.typeToDataType(param.getParameter().getType()));
			} else if (op.getOperand() instanceof CountExpression count) {
				dataTypes.add(ValueExpressionDataType.INTEGER);
			} else if (op.getOperand() instanceof ArithmeticLiteral lit) {
				if (lit.getValue() instanceof DoubleLiteral) {
					dataTypes.add(ValueExpressionDataType.DOUBLE);
				} else if (lit.getValue() instanceof IntegerLiteral) {
					dataTypes.add(ValueExpressionDataType.INTEGER);
				} else if (lit.getValue() instanceof StringLiteral) {
					dataTypes.add(ValueExpressionDataType.STRING);
				} else if (lit.getValue() instanceof BooleanLiteral) {
					dataTypes.add(ValueExpressionDataType.BOOLEAN);
				} else {
					throw new UnsupportedOperationException("Unkown arithmetic literal type: " + lit.getValue());
				}
			} else if (op.getOperand() instanceof EnumExpression en) {
				dataTypes.add(ValueExpressionDataType.ENUM);
			} else if (op.getOperand() instanceof Constant con) {
				if (con.getValue() == ConstantLiteral.E || con.getValue() == ConstantLiteral.PI) {
					dataTypes.add(ValueExpressionDataType.DOUBLE);
				} else if (con.getValue() == ConstantLiteral.NULL) {
					dataTypes.add(ValueExpressionDataType.NULL);
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

}
