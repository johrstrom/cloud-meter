package org.apache.jmeter.control.model;

import org.apache.jmeter.control.WhileController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class WhileControllerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		WhileController ele = new WhileController();
		this.baseElement(ele, "While Controller");
		
		ele.setCondition(EMPTY_STRING);
		
		
		return ele;
	}

}
