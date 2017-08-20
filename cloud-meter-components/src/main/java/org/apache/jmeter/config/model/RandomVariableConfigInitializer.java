package org.apache.jmeter.config.model;

import org.apache.jmeter.config.RandomVariableConfig;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class RandomVariableConfigInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		RandomVariableConfig ele = new RandomVariableConfig();
		this.baseElement(ele,"Random Variable");
		
		ele.setMinimumValue("1");
		ele.setMaximumValue(EMPTY_STRING);
		ele.setOutputFormat(EMPTY_STRING);
		ele.setPerThread(false);
		ele.setRandomSeed(EMPTY_STRING);
		ele.setVariableName(EMPTY_STRING);
		
		return ele;
	}

}
