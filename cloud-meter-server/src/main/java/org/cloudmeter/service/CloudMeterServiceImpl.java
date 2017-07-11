package org.cloudmeter.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.model.TestElementModel;
import org.springframework.stereotype.Component;

@Component
public class CloudMeterServiceImpl implements CloudMeterService {
	

	private static final Map<String, Class<? extends AbstractTestElement>> classTypeLookup = typeToClassMap();
    
	
	@Override
	public TestElementModel newTestElement(String name, String type) {
		
    	if (type != null && !type.equals("")) {
    		Class<? extends AbstractTestElement> clazz = classTypeLookup.get(type);
    		try {
				AbstractTestElement instance = clazz.newInstance();
				
				this.setElementName(name, instance);
				TestElementModel model = new TestElementModel();
				
				model.setElement(instance);
				model.setType(type);
				model.setHashTree(new HashTree());
				
				return model;
				
			} catch (InstantiationException | IllegalAccessException e) {
				throw new IllegalArgumentException("Cannot instantiate elememnt of type " + type);
			}
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
