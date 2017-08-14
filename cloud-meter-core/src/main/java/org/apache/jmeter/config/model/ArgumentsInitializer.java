package org.apache.jmeter.config.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class ArgumentsInitializer extends AbstractInitialzer {

	public static final String DEFAULT_NAME = "User Defined Variables"; 
	
	@Override
	public TestElement initilizeElement() {
		Arguments args = new Arguments();
		this.baseElement(args, DEFAULT_NAME);
		
		
		
		return args;
	}

}
