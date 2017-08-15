package org.apache.jmeter.config.model;

import org.apache.jmeter.config.KeystoreConfig;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class KeystoreConfigInitializer  extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		KeystoreConfig ele = new KeystoreConfig();
		this.baseElement(ele, "Keystore Configuration");
		
		ele.setClientCertAliasVarName(EMPTY_STRING);
		ele.setEndIndex(EMPTY_STRING);
		ele.setStartIndex(EMPTY_STRING);
		ele.setPreload(true);
		
		return ele;
	}

}
