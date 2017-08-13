package org.cloudmeter.service;

import java.util.Map;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.testelement.TestElementFactory;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.model.TestElementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CloudMeterServiceImpl implements CloudMeterService {

	@Autowired
	@Qualifier("testElementNameLookup")
	private Map<String, Class<? extends AbstractTestElement>> classTypeLookup;
  
	@Autowired
	private TestElementFactory elementFactory;
	
	@Override
	public TestElementModel newTestElement(String name, String type) {
		
    	if (type != null && !type.equals("")) {
    		Class<? extends AbstractTestElement> clazz = classTypeLookup.get(type);
    		
			
    		//TODO throws null here if it can't instantiate!
    		TestElement ele = elementFactory.newElement(clazz);    		
			this.setElementName(name, ele);
			
			TestElementModel model = new TestElementModel();
			model.setTestElement(ele);
			model.setType(TestElementModel.getElementType(ele));
			model.setHashTree(new HashTree());
			
			return model;
			
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
