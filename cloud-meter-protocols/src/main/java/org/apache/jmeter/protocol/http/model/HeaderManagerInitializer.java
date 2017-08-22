package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class HeaderManagerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		HeaderManager ele = new HeaderManager();
		this.baseElement(ele, "HTTP Header Manager");
		
		
		
		return ele;
	}

	
}
