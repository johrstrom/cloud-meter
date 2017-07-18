package org.cloudmeter.utils;

import org.apache.jmeter.assertions.Assertion;
import org.apache.jmeter.config.ConfigElement;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.processor.PostProcessor;
import org.apache.jmeter.processor.PreProcessor;
import org.apache.jmeter.reporters.AbstractListenerElement;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.testelement.WorkBench;
import org.apache.jmeter.threads.AbstractThreadGroup;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.timers.Timer;
import org.cloudmeter.model.ModelInitializer;
import org.cloudmeter.model.threads.ThreadGroupInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestElementInitializer  implements ModelInitializer {
	
	@Autowired
	private ThreadGroupInitializer threadGroupIniter;

	@Override
	public TestElement initilizeElement(TestElement ele) {
			
		if (ele instanceof Assertion) {
			return initializeAssertion(ele);
			
		}else if (ele instanceof ConfigElement) {
			return initializeConfigElement(ele);
			
		}else if (ele instanceof AbstractListenerElement) {
			return initializeAbstractListenerElement(ele);
			
		}else if (ele instanceof PostProcessor) {
			return initializePostProcessor(ele);
			
		}else if (ele instanceof PreProcessor) {
			return initializePreProcessor(ele);
			
		}else if (ele instanceof AbstractSampler) {
			return initializeAbstractSampler(ele);
			
		}else if (ele instanceof TestPlan) {
			return initializeTestPlan(ele);
			
		}else if (ele instanceof AbstractThreadGroup) {
			return intializeAbstractThreadGroup(ele);
			
		}else if (ele instanceof Timer) {
			return intializeTimer(ele);
			
		}else if (ele instanceof WorkBench) {
			return intializeWorkBench(ele);
			
		}else {
			return ele;
		}

	}
	
	private TestElement initializeAssertion(TestElement ele) {
		return ele;
	}
	
	private TestElement initializeConfigElement(TestElement ele) {
		return ele;	
	}
	
	private TestElement initializeAbstractListenerElement(TestElement ele) {
		return ele;	
	}
	
	private TestElement initializePostProcessor(TestElement ele) {
		return ele;
	}
	
	private TestElement initializePreProcessor(TestElement ele) {
		return ele;
	}
	
	private TestElement intializeAbstractThreadGroup(TestElement ele) {
		if(ele instanceof ThreadGroup) {
			return threadGroupIniter.initilizeElement(ele);
		}else {
			return ele;
		}
	}
	
	private TestElement initializeAbstractSampler(TestElement ele) {
		return ele;
	}
	
	private TestElement initializeTestPlan(TestElement ele) {
		return ele;
	}
	
	private TestElement intializeTimer(TestElement ele) {
		return ele;
	}

	private TestElement intializeWorkBench(TestElement ele) {
		return ele;
	}

	
	
}





























