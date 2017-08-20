package org.apache.jmeter.control.model;

import org.apache.jmeter.control.OnceOnlyController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class OnceOnlyControllerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		OnceOnlyController ele = new OnceOnlyController();
		this.baseElement(ele, "Once Only Controller");
		
		return ele;
	}

}
