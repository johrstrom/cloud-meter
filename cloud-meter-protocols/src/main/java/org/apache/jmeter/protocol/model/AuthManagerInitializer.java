package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.http.control.AuthManager;
import org.apache.jmeter.protocol.http.control.Authorization;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class AuthManagerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		AuthManager ele = new AuthManager();
		this.baseElement(ele,"HTTP Authorization Manager");
	
		
		return ele;
	}

}
