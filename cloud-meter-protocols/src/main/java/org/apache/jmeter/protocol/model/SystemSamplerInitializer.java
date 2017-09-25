package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.protocol.system.SystemSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class SystemSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		SystemSampler ele = new SystemSampler();
		this.baseElement(ele, "OS Process Sampler");
		
		Arguments args = (Arguments) new ArgumentsInitializer().initilizeElement();
		Arguments envVars = (Arguments) new ArgumentsInitializer().initilizeElement();
		ele.setArguments(args);
		ele.setEnvironmentVariables(envVars);
		
		ele.setCheckReturnCode(false);
		ele.setCommand(EMPTY_STRING);
		ele.setDirectory(EMPTY_STRING);
		ele.setExpectedReturnCode(0);
		
		
		return ele;
	}

}
