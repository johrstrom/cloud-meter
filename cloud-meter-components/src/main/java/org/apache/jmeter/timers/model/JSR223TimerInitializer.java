package org.apache.jmeter.timers.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.JSR223Timer;
import org.cloudmeter.model.ScriptingElementInitializer;

public class JSR223TimerInitializer extends ScriptingElementInitializer {

	@Override
	public TestElement initilizeElement() {
		JSR223Timer ele = new JSR223Timer();
		this.baseElement(ele, "JSR223 Timer");
		this.initScriptingElement(ele);
		
		ele.setCacheKey(EMPTY_STRING);
		ele.setScriptLanguage("groovy");
		
		
		return ele;
	}

}
