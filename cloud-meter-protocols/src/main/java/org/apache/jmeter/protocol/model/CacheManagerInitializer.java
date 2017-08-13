package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.http.control.CacheManager;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class CacheManagerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		CacheManager ele = new CacheManager();
		this.baseElement(ele, "HTTP Cache Manager");
		
		ele.setMaxSize(5000);
		ele.setUseExpires(false);
		
		return ele;
	}

}
