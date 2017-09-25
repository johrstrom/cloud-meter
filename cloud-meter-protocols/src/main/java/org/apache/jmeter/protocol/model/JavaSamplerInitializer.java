package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.protocol.java.sampler.JavaSampler;
import org.apache.jmeter.protocol.java.test.JavaTest;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class JavaSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		JavaSampler ele = new JavaSampler();
		this.baseElement(ele, "Java Request");

		
		ele.setArguments(initializeArgs());
		ele.setClassname(JavaTest.class.getName());
		
		return ele;
	}
	
	private Arguments initializeArgs() {
		ArgumentsInitializer argIniter = new ArgumentsInitializer();
		Arguments args = (Arguments) argIniter.initilizeElement();
		
        args.addArgument("Label","");
		args.addArgument("ResponseCode", "");
		args.addArgument("ResponseMessage", "");
		args.addArgument("ResultData", "");
		args.addArgument("SamplerData", "");
		args.addArgument("Sleep_Mask", "0xFF");
		args.addArgument("Sleep_Time", "100");
		args.addArgument("Status", "OK");
		
		return args;		
	}

}
