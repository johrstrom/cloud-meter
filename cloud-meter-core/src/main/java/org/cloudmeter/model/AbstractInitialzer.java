package org.cloudmeter.model;

import org.apache.jmeter.testelement.TestElement;

public abstract class AbstractInitialzer implements ModelInitializer {
	
	public static final String EMPTY_STRING = "";

	
	protected void baseElement(TestElement ele, String name) {
		ele.setEnabled(true);
		ele.setProperty(TestElement.ENABLED, true);
		
		ele.setName(name);
		ele.setProperty(TestElement.NAME, name);
		
		ele.setTestClass(ele.getClass().getName());
	}
}
