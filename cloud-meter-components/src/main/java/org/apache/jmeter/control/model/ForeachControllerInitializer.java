package org.apache.jmeter.control.model;

import org.apache.jmeter.control.ForeachController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;
import org.cloudmeter.model.ModelInitializer;

public class ForeachControllerInitializer extends AbstractInitialzer implements ModelInitializer {

	@Override
	public TestElement initilizeElement() {
		ForeachController ele = new ForeachController();

		return ele;
	}

}
