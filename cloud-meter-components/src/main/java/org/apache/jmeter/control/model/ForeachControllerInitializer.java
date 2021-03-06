package org.apache.jmeter.control.model;

import org.apache.jmeter.control.ForeachController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class ForeachControllerInitializer extends AbstractInitializer {

	public static final String DEFAULT_NAME = "ForEach Controller";
	
	@Override
	public TestElement initilizeElement() {
		ForeachController ele = new ForeachController();
		this.baseElement(ele, DEFAULT_NAME);
		
		ele.setStartIndex(EMPTY_STRING);
		ele.setEndIndex(EMPTY_STRING);
		ele.setReturnVal(EMPTY_STRING);
		ele.setInputVal(EMPTY_STRING);
		ele.setUseSeparator(true);

		return ele;
	}

}
