package org.apache.jmeter.control.model;

import org.apache.jmeter.control.IncludeController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class IncludeControllerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		IncludeController ele = new IncludeController();
		this.baseElement(ele, "Include Controller");
		
		ele.setIncludePath(EMPTY_STRING);
	
		return ele;
	}

}
