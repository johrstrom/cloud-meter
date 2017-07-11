package org.cloudmeter.service;

import org.cloudmeter.model.TestElementModel;

public interface CloudMeterService {
	
	public TestElementModel newTestElement(String name, String type);

}
