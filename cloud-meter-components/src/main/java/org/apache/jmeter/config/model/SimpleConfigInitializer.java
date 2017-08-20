package org.apache.jmeter.config.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class SimpleConfigInitializer extends AbstractInitializer{

	@Override
	public TestElement initilizeElement() {
		ConfigTestElement ele = new ConfigTestElement();
		this.baseElement(ele, "Simple Config Element");
		
		return ele;
	}

}
