package org.emoflon.ibex.tgg.ui.debug.adapter.TGGAdapter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.ibex.tgg.ui.debug.api.Attribute;

public class EAttributeAdapter implements Attribute {
	
	public static EAttributeAdapter adapt(EObject owner, EAttribute attribute) {
		return new EAttributeAdapter(owner, attribute);
	}
	
	public static EAttributeAdapter adapt(EAttribute attribute) {
		return new EAttributeAdapter(attribute);
	}
	
	private final String type;
	
	private Object value;
	
	private final String name;
	
	private EAttributeAdapter(EObject owner, EAttribute attribute) {
		this(attribute);
		this.value = owner.eGet(attribute);
	}
	
	private EAttributeAdapter(EAttribute attribute) {
		this.type = this.mapEcoreDataTypes(attribute.getEType().getName());
		this.name = attribute.getName();
		this.value = null;
	}
	
	private String mapEcoreDataTypes(String dataType) {
		String targetDataType = "Object";
		switch(dataType) {
		case "EBoolean" : targetDataType = "boolean"; break;
		case "EByte" : targetDataType = "byte"; break;
		case "EChar" : targetDataType = "char"; break;
		case "EDouble" : targetDataType = "double"; break;
		case "EFloat" : targetDataType = "float"; break;
		case "EInt" : targetDataType = "int"; break;
		case "ELong" : targetDataType = "long"; break;
		case "EShort" : targetDataType = "short"; break;
		case "EByteArray" : targetDataType = "byte[]"; break;
		case "EBooleanObject" : targetDataType = "java.lang.Boolean"; break;
		case "EByteObject" : targetDataType = "	java.lang.Byte"; break;
		case "ECharacterObject" : targetDataType = "java.lang.Character"; break;
		case "EDoubleObject" : targetDataType = "java.lang.Double"; break;
		case "EFloatObject" : targetDataType = "java.lang.Float"; break;
		case "EIntegerObject" : targetDataType = "java.lang.Integer"; break;
		case "ELongObject" : targetDataType = "java.lang.Long"; break;
		case "EShortObject" : targetDataType = "java.lang.Short"; break;
		case "EBigDecimal" : targetDataType = "java.math.BigDecimal"; break;
		case "EBigInteger" : targetDataType = "java.math.BigInteger"; break;
		case "EDate" : targetDataType = "java.util.Date"; break;
		case "EJavaObject" : targetDataType = "java.lang.Object"; break;
		case "EJavaClass" : targetDataType = "java.lang.Class"; break;
		case "EString" : targetDataType = "java.lang.String"; break;
		}
		return targetDataType;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public Object getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String returnValue = this.getType() + " " + this.getName();
		if(this.getValue() != null) {
			returnValue += " = "+this.getValue().toString();
		}
		return returnValue;
	}

}
