package org.cloudmeter.testelement;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.ModelInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestElementFactory {
	
	private static final Logger log = LoggerFactory.getLogger(TestElementFactory.class);
	
	@Autowired
	private ApplicationContext context;
	
	public TestElementFactory(){
		
	}

	public TestElement newElement(Class<? extends AbstractTestElement> clazz) {
		try {
			
			
			AbstractTestElement instance = clazz.newInstance();
			String initerName = instance.getPropertyAsString(TestElement.MODEL_INITIALIZER);
			
			log.debug("Instantiating a new {} with initializer {}", clazz.getName(), initerName);
			Class<?> initerType = Class.forName(initerName);
			ModelInitializer initer = (ModelInitializer) context.getBean(initerType);
			
			return initer.initilizeElement();
			
		} catch (Exception e) {
			log.error("Couldn't initialize element {} because of exception {} reason {}", 
					clazz.getName(),e.getClass().getName(), e.getMessage());
			
			return null;
		}
		
		
	}

}
