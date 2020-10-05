package org.emoflon.ibex.tgg.integrate.api.variable;

public class TypeFilterData {
	private final String elementName;

	private final String packageName;
	
	public TypeFilterData(String elementName, String packageName) {
		this.elementName = elementName;
		this.packageName = packageName;
	}
	
	public String getElementName() {
		return elementName;
	}

	public String getPackageName() {
		return packageName;
	}
}
