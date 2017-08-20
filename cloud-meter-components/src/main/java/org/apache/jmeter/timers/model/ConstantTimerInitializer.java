package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.ConstantTimer;
import org.cloudmeter.model.AbstractInitializer;

public class ConstantTimerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConstantTimer ele = new ConstantTimer();
		this.baseElement(ele, "Constant Timer");
		
		ele.setDelay("300");
		ele.setRange(0.0);
		
		return ele;
	}

}
