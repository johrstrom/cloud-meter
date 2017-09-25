package org.apache.jmeter.sampler.model;

import org.apache.jmeter.sampler.TestAction;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class TestActionInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		TestAction ele = new TestAction();
		this.baseElement(ele, "Test Action");
		
		ele.setAction(1);
		ele.setDuration(EMPTY_STRING);
		ele.setTarget(0);
		
		return ele;
	}

}
