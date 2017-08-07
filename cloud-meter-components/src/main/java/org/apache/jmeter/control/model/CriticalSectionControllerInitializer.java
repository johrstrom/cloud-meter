package org.apache.jmeter.control.model;

import org.apache.jmeter.control.CriticalSectionController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;
import org.cloudmeter.model.ModelInitializer;
import org.springframework.stereotype.Component;


@Component
public class CriticalSectionControllerInitializer extends AbstractInitialzer implements ModelInitializer {

	@Override
	public TestElement initilizeElement() {
		CriticalSectionController ele = new CriticalSectionController();
		this.baseElement(ele, "Critical Section Controller");
		
		ele.setLockName("global_lock");
		
		
		return ele;
	}

}
