package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.protocol.http.modifier.RegExUserParameters;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class RegExUserParametersInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		RegExUserParameters ele = new RegExUserParameters();
		this.baseElement(ele, "RegEx User Parameters");
		
		ele.setRegExParamNamesGrNr(EMPTY_STRING);
		ele.setRegExParamValuesGrNr(EMPTY_STRING);
		ele.setRegExRefName(EMPTY_STRING);
		
		return ele;
	}

}
