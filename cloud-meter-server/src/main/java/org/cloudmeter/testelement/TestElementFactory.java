package org.cloudmeter.testelement;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.model.TestElementModel;
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

	public TestElementModel newElementByBeanName(String name) {
		if (name == null)
			return null;
		
		try {
			TestElementModel model = new TestElementModel();
			
			TestElement ele = (TestElement) context.getBean(name);
			model.setTestElement(ele);
			model.setType(TestElementModel.getElementType(ele));
			model.setHashTree(new HashTree());
			
			return model;
						
		} catch (Exception e) {
			log.error("Couldn't initialize element {} because of exception {} reason {}", 
					name,e.getClass().getName(), e.getMessage());
			
			return null;
		}
		
		
	}

}
