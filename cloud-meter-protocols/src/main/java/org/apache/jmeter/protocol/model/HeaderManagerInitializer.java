package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class HeaderManagerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		HeaderManager ele = new HeaderManager();
		this.baseElement(ele, "HTTP Header Manager");
		
		
		
		return ele;
	}

	
}
