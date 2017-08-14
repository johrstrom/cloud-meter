package org.apache.jmeter.modifiers.model;

import org.apache.jmeter.modifiers.CounterConfig;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class CounterConfigInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		CounterConfig ele = new CounterConfig();
		this.baseElement(ele, "Counter");
		
		ele.setEnd(Long.MAX_VALUE);
		ele.setStart(0l);
		ele.setFormat(EMPTY_STRING);
		ele.setIncrement(EMPTY_STRING);
		ele.setIsPerUser(false);
		ele.setVarName(EMPTY_STRING);
		
		return ele;
	}

}
