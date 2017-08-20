package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.UniformRandomTimer;
import org.cloudmeter.model.AbstractInitializer;

public class UniformRandomTimerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		UniformRandomTimer ele = new UniformRandomTimer();
		this.baseElement(ele, "Uniform Random Timer");
		
		ele.setDelay(0);
		ele.setRange(100.0);
		
		return ele;
	}

}
