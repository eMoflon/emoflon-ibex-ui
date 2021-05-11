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
	
	private final String typeName;
	
	private EAttributeAdapter(EObject owner, EAttribute attribute) {
		this(attribute);
		this.value = owner.eGet(attribute);
	}
	
	private EAttributeAdapter(EAttribute attribute) {
		this.typeName = attribute.getEType().getName();
		this.type = attribute.getEType().getInstanceTypeName();
		this.name = attribute.getName();
		this.value = null;
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
	
	public String getTypeName() {
		return this.typeName;
	}
	
	@Override
	public String toString() {
		String returnValue = this.getTypeName() + " " + this.getName();
		if(this.getValue() != null) {
			returnValue += " = "+this.getValue().toString();
		}
		return returnValue;
	}

}
