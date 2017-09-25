package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.tcp.sampler.TCPClientImpl;
import org.apache.jmeter.protocol.tcp.sampler.TCPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class TCPSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		TCPSampler ele = new TCPSampler();
		this.baseElement(ele, "TCP Sampler");
		
		ele.setProperty(ConfigTestElement.PASSWORD, EMPTY_STRING);
		ele.setProperty(ConfigTestElement.USERNAME, EMPTY_STRING);
		ele.setCloseConnection(false);
		ele.setProperty(TCPSampler.NODELAY, false);
		ele.setPort(0);
		ele.setProperty(TCPSampler.RE_USE_CONNECTION, true);
		ele.setRequestData(EMPTY_STRING);
		ele.setServer(EMPTY_STRING);
		ele.setTimeout(0);
		//ele.setClassname(TCPClientImpl.class.getSimpleName());
		ele.setCloseConnection(false);
		
		return ele;
	}

}
