package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.ftp.sampler.FTPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class FTPConfigInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConfigTestElement ele = new ConfigTestElement();
		this.baseElement(ele, "FTP Request Defaults");
		
		ele.setProperty(FTPSampler.BINARY_MODE, false);
		ele.setProperty(FTPSampler.REMOTE_FILENAME, EMPTY_STRING);
		ele.setProperty(FTPSampler.INPUT_DATA, EMPTY_STRING);
		ele.setProperty(FTPSampler.LOCAL_FILENAME, EMPTY_STRING);
		ele.setProperty(FTPSampler.PORT, EMPTY_STRING);
		ele.setProperty(FTPSampler.SAVE_RESPONSE, false);
		ele.setProperty(FTPSampler.SERVER, EMPTY_STRING);
		ele.setProperty(FTPSampler.UPLOAD_FILE, false);
		
		return ele;
	}

}
