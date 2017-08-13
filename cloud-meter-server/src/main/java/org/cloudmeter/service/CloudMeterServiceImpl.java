package org.cloudmeter.service;

import java.util.Map;

import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.testelement.TestElementFactory;
import org.cloudmeter.model.TestElementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CloudMeterServiceImpl implements CloudMeterService {

	@Autowired
	@Qualifier("testElementNameLookup")
	private Map<String, String> apiTypeToBeanLookup;
  
	@Autowired
	private TestElementFactory elementFactory;
	
	@Override
	public TestElementModel newTestElement(String name, String type) {
		
    	if (type != null && !type.equals("")) {
    		
    		String beanName = this.apiTypeToBeanLookup.get(type);
    		
    		//TODO throws null here if it can't instantiate!
    		return elementFactory.newElementByBeanName(beanName);		
			
    	}else {
    		throw new IllegalArgumentException("type cannot be empty or null");
    	}
    	
	}	

	private void setElementName(final String name, TestElement ele) {
		if(name != null && !name.equals("")) {
			ele.setName(name);
		}
	}


}
