package org.apache.jmeter.modifiers.model;

import org.apache.jmeter.modifiers.BeanShellPreProcessor;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.BeanShellInitializer;

public class BeanShellPreProcessorInitializer extends BeanShellInitializer {

	@Override
	public TestElement initilizeElement() {
		BeanShellPreProcessor ele = new BeanShellPreProcessor();
		this.baseElement(ele, "BeanShell PreProcessor");
		this.initBeanShellElement(ele);
		
		return ele;
	}

}
