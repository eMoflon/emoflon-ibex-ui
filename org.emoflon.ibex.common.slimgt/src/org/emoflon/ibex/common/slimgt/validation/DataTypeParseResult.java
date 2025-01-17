package org.emoflon.ibex.common.slimgt.validation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public record DataTypeParseResult(ValueExpressionDataType type, boolean errorOccurred,
		Map<EObject, List<EStructuralFeature>> context2Location,
		Map<EObject, List<ValueExpressionDataType>> context2ErrorTypes) {

	public DataTypeParseResult(ValueExpressionDataType type) {
		this(type, false, new HashMap<>(), new HashMap<>());
	}

	public DataTypeParseResult(ValueExpressionDataType type, EObject context, EStructuralFeature location) {
		this(type, type == ValueExpressionDataType.CONFLICT || type == ValueExpressionDataType.UNSUPPORTED,
				new HashMap<>(), new HashMap<>());
		if (errorOccurred) {
			context2Location.put(context, List.of(location));
			context2ErrorTypes.put(context, List.of(type));
		}

	}

	public DataTypeParseResult(ValueExpressionDataType type, Map<EObject, List<EStructuralFeature>> context2Location,
			Map<EObject, List<ValueExpressionDataType>> context2ErrorTypes) {
		this(type, type == ValueExpressionDataType.CONFLICT || type == ValueExpressionDataType.UNSUPPORTED,
				new HashMap<>(), new HashMap<>());
		if (errorOccurred) {
			this.context2Location.putAll(context2Location);
			this.context2ErrorTypes.putAll(context2ErrorTypes);
		}

	}

	public static DataTypeParseResult mergeResult(final DataTypeParseResult result1, final DataTypeParseResult result2,
			EObject context, List<EStructuralFeature> locations) {
		ValueExpressionDataType mainType = null;
		if (result1.type == ValueExpressionDataType.UNSUPPORTED
				|| result2.type == ValueExpressionDataType.UNSUPPORTED) {
			mainType = ValueExpressionDataType.UNSUPPORTED;
		}

		if (mainType == null && (result1.type == ValueExpressionDataType.CONFLICT
				|| result2.type == ValueExpressionDataType.CONFLICT)) {
			mainType = ValueExpressionDataType.CONFLICT;
		}

		Map<EObject, List<EStructuralFeature>> context2Location = new HashMap<>();
		context2Location.putAll(result1.context2Location());
		context2Location.putAll(result2.context2Location());
		Map<EObject, List<ValueExpressionDataType>> context2ErrorTypes = new HashMap<>();
		context2ErrorTypes.putAll(result1.context2ErrorTypes());
		context2ErrorTypes.putAll(result2.context2ErrorTypes());

		if (mainType != null) {
			return new DataTypeParseResult(mainType, true, context2Location, context2ErrorTypes);
		}

		mainType = switch (result1.type) {
		case BOOLEAN -> {
			yield ValueExpressionDataType.mergeWithBoolean(result2.type);
		}
		case DATE -> {
			yield ValueExpressionDataType.mergeWithDate(result2.type);
		}
		case DOUBLE -> {
			yield ValueExpressionDataType.mergeWithDouble(result2.type);
		}
		case ENUM -> {
			yield ValueExpressionDataType.mergeWithEnum(result2.type);
		}
		case INTEGER -> {
			yield ValueExpressionDataType.mergeWithInteger(result2.type);
		}
		case NULL -> {
			yield ValueExpressionDataType.mergeWithNull(result2.type);
		}
		case STRING -> {
			yield ValueExpressionDataType.mergeWithString(result2.type);
		}
		case OBJECT -> {
			yield ValueExpressionDataType.mergeWithObject(result2.type);
		}
		default -> {
			yield ValueExpressionDataType.CONFLICT;
		}
		};

		if (mainType == ValueExpressionDataType.CONFLICT) {
			List<EStructuralFeature> loc = context2Location.get(context);
			if (loc == null) {
				loc = new LinkedList<>();
				context2Location.put(context, loc);
			}
			loc.addAll(locations);
			List<ValueExpressionDataType> errs = context2ErrorTypes.get(context);
			if (errs == null) {
				errs = new LinkedList<>();
				context2ErrorTypes.put(context, errs);
			}
			errs.add(mainType);
		}

		return new DataTypeParseResult(mainType, context2Location, context2ErrorTypes);

	}
}
