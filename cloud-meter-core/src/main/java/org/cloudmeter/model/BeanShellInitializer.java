package org.cloudmeter.model;

import org.apache.jmeter.util.BeanShellTestElement;

public abstract class BeanShellInitializer extends AbstractInitializer {
	
	protected void initBeanShellElement(BeanShellTestElement ele) {
		ele.setFilename(EMPTY_STRING);
		ele.setParameters(EMPTY_STRING);
		ele.setResetInterpreter(false);
		ele.setScript(EMPTY_STRING);
	}

}
