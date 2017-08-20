package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.SyncTimer;
import org.cloudmeter.model.AbstractInitializer;

public class SyncTimerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		SyncTimer ele = new SyncTimer();
		this.baseElement(ele, "Synchronizing Timer");
		
		ele.setGroupSize(0);
		ele.setTimeoutInMs(0l);
		
		return ele;
	}

}
