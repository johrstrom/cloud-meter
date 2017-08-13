package org.apache.jmeter.control.model;

import org.apache.jmeter.control.RandomOrderController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class RandomOrderControllerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		RandomOrderController ele = new RandomOrderController();
		this.baseElement(ele, "Random Order Controller");
	
		
		return ele;
	}

}

