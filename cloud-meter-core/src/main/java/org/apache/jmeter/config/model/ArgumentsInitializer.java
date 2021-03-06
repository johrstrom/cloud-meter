package org.apache.jmeter.config.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class ArgumentsInitializer extends AbstractInitializer {

	public static final String DEFAULT_NAME = "User Defined Variables"; 
	
	@Override
	public TestElement initilizeElement() {
		Arguments args = new Arguments();
		this.baseElement(args, DEFAULT_NAME);
		
		
		
		return args;
	}

}
