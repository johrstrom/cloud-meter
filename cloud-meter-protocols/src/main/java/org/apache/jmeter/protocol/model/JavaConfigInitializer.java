package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.config.JavaConfig;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class JavaConfigInitializer extends AbstractInitialzer {
	
	@Override
	public TestElement initilizeElement() {
		JavaConfig ele = new JavaConfig();
		this.baseElement(ele,"Java Request Defaults");
		
		ele.setArguments(this.createArgs());
		ele.setProperty("classname", "org.apache.jmeter.protocol.java.test.JavaTest");
		
		return ele;
	}
	
	
	private Arguments createArgs() {
		
		Arguments args = new Arguments();	//can't use arg initer bc this has no TestElement.name 
		args.setEnabled(true);
		args.setTestClass(args.getClass().getName());
		
		args.addArgument("Label", EMPTY_STRING);
		args.addArgument("ResponseMessage", EMPTY_STRING);
		args.addArgument("ResponseCode", EMPTY_STRING);
		args.addArgument("ResultData", EMPTY_STRING);
		args.addArgument("SamplerData", EMPTY_STRING);
		args.addArgument("Sleep_Mask", "0xFF");
		args.addArgument("Sleep_Time", "100");
		args.addArgument("Status", "OK");
		
		return args;
	}
	
}
