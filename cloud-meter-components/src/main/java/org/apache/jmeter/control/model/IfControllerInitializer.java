package org.apache.jmeter.control.model;

import org.apache.jmeter.control.IfController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;
import org.cloudmeter.model.ModelInitializer;
import org.springframework.stereotype.Component;

@Component
public class IfControllerInitializer extends AbstractInitialzer implements ModelInitializer {

	public static final String DEFAULT_NAME = "If Controller"; 
			
	@Override
	public TestElement initilizeElement() {
		IfController ele = new IfController();
		this.baseElement(ele, DEFAULT_NAME);
		
		
		ele.setCondition(EMPTY_STRING);
		ele.setEvaluateAll(false);
		
		return ele;
	}
	
	
}
