package org.apache.jmeter.control.model;

import org.apache.jmeter.control.RandomController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class RandomControllerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		RandomController ele = new RandomController();
		this.baseElement(ele, "Random Controller");
		
		ele.setStyle(1);
		
		return ele;
	}

}
