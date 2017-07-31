package org.cloudmeter.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.model.TestElementModel;
import org.cloudmeter.server.util.TestElementFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloudMeterServiceImpl implements CloudMeterService {
	
	private static final Logger log = LoggerFactory.getLogger(CloudMeterServiceImpl.class);

	private static final Map<String, Class<? extends AbstractTestElement>> classTypeLookup = typeToClassMap();
    
	
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
			model.setElement(ele);
			model.setType(type);
			model.setHashTree(new HashTree());
			
			log.debug("returning new test element model " + model.toString());
			
			return model;
			
    	}else {
    		throw new IllegalArgumentException("type cannot be empty or null");
    	}
    	
	}
	
	
	private static Map<String, Class<? extends AbstractTestElement>> typeToClassMap() {
    	HashMap<String, Class<? extends AbstractTestElement>>  map = new HashMap<>();
    	
    	map.put("thread-group", ThreadGroup.class);
    	
    	return map;
    }
	

	private void setElementName(final String name, TestElement ele) {
		if(name != null && !name.equals("")) {
			ele.setName(name);
		}
	}
	


}
