package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.http.modifier.AnchorModifier;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class HTMLLinkPreProcessorInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		AnchorModifier ele = new AnchorModifier();
		this.baseElement(ele, "HTML Link Parser");
		
		return ele;
	}

}
