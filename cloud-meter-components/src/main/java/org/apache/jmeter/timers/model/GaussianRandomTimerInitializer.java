package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.GaussianRandomTimer;
import org.cloudmeter.model.AbstractInitializer;

public class GaussianRandomTimerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		GaussianRandomTimer ele = new GaussianRandomTimer();
		this.baseElement(ele, "Gaussian Random Timer");
		
		ele.setDelay(300);
		ele.setRange(100.0);
		
		
		return ele;
	}

}
