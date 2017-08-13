package org.apache.jmeter.control.model;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class LoopControllerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		LoopController ele = new LoopController();
		this.baseElement(ele, "Loop Controller");
		
		ele.setLoops(1);
		ele.setContinueForever(true);
		
		return ele;
	}

}
