package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.ConstantThroughputTimer;
import org.cloudmeter.model.AbstractInitializer;

public class ConstantThroughputTimerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConstantThroughputTimer ele = new ConstantThroughputTimer();
		this.baseElement(ele, "Constant Throughput Timer");
		
		ele.setCalcMode(0);
		ele.setThroughput(0.0);
		
		return ele;
	}

}
