package org.apache.jmeter.modifiers.model;

import org.apache.jmeter.modifiers.SampleTimeout;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class SampleTimeoutInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		SampleTimeout ele = new SampleTimeout();
		this.baseElement(ele, "Sample Timeout");
		
		ele.setTimeout(10000);
		
		return ele;
	}

}
