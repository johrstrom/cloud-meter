package org.apache.jmeter.config.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class LoginConfigInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConfigTestElement ele = new ConfigTestElement();
		this.baseElement(ele, "Login Config Element");
		
		ele.setProperty("ConfigTestElement.password", EMPTY_STRING);
		ele.setProperty("ConfigTestElement.username", EMPTY_STRING);
		
		return ele;
	}

}
