package org.cloudmeter.testelement;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
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
		if (clazz == null)
			return null;
		
		try {
			
			return (TestElement) context.getBean(clazz.getSimpleName());
						
		} catch (Exception e) {
			log.error("Couldn't initialize element {} because of exception {} reason {}", 
					clazz.getName(),e.getClass().getName(), e.getMessage());
			
			return null;
		}
		
		
	}

}
