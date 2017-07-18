package org.cloudmeter.utils;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.threads.ThreadGroup;
import org.cloudmeter.model.ModelInitializer;
import org.cloudmeter.model.threads.ThreadGroupInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestElementInitializer  implements ModelInitializer {
		
	@Autowired
	private ThreadGroupInitializer tgInit;

	@Override
	public void initilizeElement(TestElement ele) {
				
		if(ele instanceof ThreadGroup) {
			tgInit.initilizeElement(ele);
		}
		
	}
	
	
}