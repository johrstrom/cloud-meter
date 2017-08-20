package org.cloudmeter.model;

import org.apache.jmeter.util.ScriptingTestElement;

public abstract class ScriptingElementInitializer extends AbstractInitializer{

	protected void initScriptingElement(ScriptingTestElement ele) {
		
		ele.setParameters(EMPTY_STRING);
		ele.setFilename(EMPTY_STRING);
		ele.setScript(EMPTY_STRING);
		
	}
	
}
