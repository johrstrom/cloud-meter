package org.cloudmeter.model;

import org.apache.jmeter.testelement.TestElement;

public abstract class AbstractInitialzer {

	
	protected void baseElement(TestElement ele) {
		ele.setEnabled(true);
	}
}
