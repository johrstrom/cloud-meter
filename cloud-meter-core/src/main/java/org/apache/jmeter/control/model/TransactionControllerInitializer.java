package org.apache.jmeter.control.model;

import org.apache.jmeter.control.TransactionController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class TransactionControllerInitializer extends AbstractInitialzer {
	
	@Override
	public TestElement initilizeElement() {
		TransactionController ele = new TransactionController();
		this.baseElement(ele, "Transaction Controller");
		
		ele.setGenerateParentSample(false);
		ele.setIncludeTimers(false);
		
		return ele;
	}
	
}
