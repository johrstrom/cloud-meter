package org.apache.jmeter.modifiers.model;

import org.apache.jmeter.modifiers.JSR223PreProcessor;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.ScriptingElementInitializer;

public class JSR223PreProcessorInitializer extends ScriptingElementInitializer {

	@Override
	public TestElement initilizeElement() {
		JSR223PreProcessor ele = new JSR223PreProcessor();
		this.baseElement(ele, "JSR223 PreProcessor");
		this.initScriptingElement(ele, "groovy");
		
		ele.setCacheKey(EMPTY_STRING);
		
		return ele;
	}

}
