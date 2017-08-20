package org.apache.jmeter.control.model;

import org.apache.jmeter.control.RandomOrderController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class RandomOrderControllerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		RandomOrderController ele = new RandomOrderController();
		this.baseElement(ele, "Random Order Controller");
	
		
		return ele;
	}

}

