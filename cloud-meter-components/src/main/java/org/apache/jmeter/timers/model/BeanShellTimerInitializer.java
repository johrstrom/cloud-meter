package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.BeanShellTimer;
import org.cloudmeter.model.BeanShellInitializer;

public class BeanShellTimerInitializer extends BeanShellInitializer {

	@Override
	public TestElement initilizeElement() {
		BeanShellTimer ele = new BeanShellTimer();
		
		this.baseElement(ele, "BeanShell Timer");
		this.initBeanShellElement(ele);
		
		return ele;
	}

}
