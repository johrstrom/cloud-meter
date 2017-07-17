package org.cloudmeter.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.controller.V1Controller;
import org.cloudmeter.model.TestElementModel;
import org.cloudmeter.utils.TestElementInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloudMeterServiceImpl implements CloudMeterService {
	
	private static final Logger log = LoggerFactory.getLogger(CloudMeterServiceImpl.class);

	private static final Map<String, Class<? extends AbstractTestElement>> classTypeLookup = typeToClassMap();
	private static final Map<Class<? extends AbstractTestElement>, String> elementNameLookup = nameToClassMap();
//	private static final Map<Class<? extends AbstractTestElement>, String> elementNameLookup = nameToClassMap();
    
	
	@Autowired
	private TestElementInitializer elementIniter; 
	
	@Override
	public TestElementModel newTestElement(String name, String type) {
		
    	if (type != null && !type.equals("")) {
    		Class<? extends AbstractTestElement> clazz = classTypeLookup.get(type);
    		try {
				
    			AbstractTestElement instance = clazz.newInstance();
				elementIniter.initilizeElement(instance);
				this.setElementName(name, instance);
				
				TestElementModel model = new TestElementModel();
				model.setElement(instance);
				model.setType(type);
				model.setHashTree(new HashTree());
				
				log.debug("returning new test element model " + model.toString());
				
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
	
	private static Map<Class<? extends AbstractTestElement>, String> nameToClassMap() {
    	HashMap<Class<? extends AbstractTestElement>, String>  map = new HashMap<>();
    	
    	map.put(ThreadGroup.class, "Thread Group");
    	
    	return map;
    }


	private void setElementName(final String name, TestElement ele) {
		if(name != null && !name.equals("")) {
			ele.setName(name);
		}
	}

}
