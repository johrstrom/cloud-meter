package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.PoissonRandomTimer;
import org.cloudmeter.model.AbstractInitializer;

public class PoissonRandomTimerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		PoissonRandomTimer ele = new PoissonRandomTimer();
		this.baseElement(ele, "Poisson Random Timer");
		
		ele.setDelay(300);
		ele.setRange(100.0);
		
		return ele;
	}

}
