package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.http.control.CookieManager;
import org.apache.jmeter.protocol.http.control.HC4CookieHandler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class CookieManagerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		CookieManager ele = new CookieManager();
		this.baseElement(ele, "HTTP Cookie Manager");
		
		ele.setClearEachIteration(false);
		ele.setImplementation(HC4CookieHandler.class.getName());
		ele.setCookiePolicy("standard");
		
		return ele;
	}

}
