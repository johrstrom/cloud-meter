package org.apache.jmeter.control.model;

import org.apache.jmeter.control.SwitchController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class SwitchControllerInitializer extends AbstractInitializer {
	
	@Override
	public TestElement initilizeElement() {
		SwitchController ele = new SwitchController();
		this.baseElement(ele, "Switch Controller");
		
		ele.setSelection(EMPTY_STRING);
		
		return ele;
	}
}



