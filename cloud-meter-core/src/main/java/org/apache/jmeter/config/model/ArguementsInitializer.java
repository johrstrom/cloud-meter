package org.apache.jmeter.config.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;
import org.cloudmeter.model.ModelInitializer;

public class ArguementsInitializer extends AbstractInitialzer implements ModelInitializer {

	public static final String DEFAULT_NAME = "Arguments"; 
	
	@Override
	public TestElement initilizeElement() {
		Arguments args = new Arguments();
		this.baseElement(args, DEFAULT_NAME);
		
		
		
		return args;
	}

}
