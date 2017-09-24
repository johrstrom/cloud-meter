package org.apache.jmeter.sampler.model;

import org.apache.jmeter.sampler.DebugSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class DebugSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		DebugSampler ele = new DebugSampler();
		this.baseElement(ele, "Debug Sampler");
		
		ele.setDisplayJMeterVariables(true);
		ele.setDisplayJMeterProperties(false);
		ele.setDisplaySystemProperties(false);
		
		return ele;
	}

}
