package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.tcp.sampler.TCPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class TCPConfigInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConfigTestElement ele = new ConfigTestElement();
		this.baseElement(ele, "TCP Sampler Config");
		
		ele.setProperty(TCPSampler.CLOSE_CONNECTION, false);
		ele.setProperty(TCPSampler.NODELAY, false);
		ele.setProperty(TCPSampler.PORT, 0);
		ele.setProperty(TCPSampler.RE_USE_CONNECTION, true);
		ele.setProperty(TCPSampler.REQUEST, EMPTY_STRING);
		ele.setProperty(TCPSampler.SERVER, EMPTY_STRING);
		ele.setProperty(TCPSampler.TIMEOUT, 0);
		
		return ele;
	}

}
