package org.cloudmeter.util;

import org.apache.jmeter.assertions.Assertion;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.processor.PostProcessor;
import org.apache.jmeter.processor.PreProcessor;
import org.apache.jmeter.reporters.AbstractListenerElement;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.testelement.WorkBench;
import org.apache.jmeter.threads.AbstractThreadGroup;
import org.apache.jmeter.timers.Timer;
import org.springframework.stereotype.Component;

@Component
public class ModelUtils {
	
	public ModelUtils() {}
	
	public String determineElementType(Object ele) {
		if (ele instanceof Assertion) {
			return "assertion";
		}else if (ele instanceof ConfigTestElement) { 
			return "config";
		}else if (ele instanceof AbstractListenerElement) {
			return "listener";
		}else if (ele instanceof PostProcessor ) {
			return "post-processor";
		}else if (ele instanceof PreProcessor ) {
			return "pre-processor";
		}else if (ele instanceof AbstractSampler) {
			return "sampler";
		}else if(ele instanceof TestPlan) {
			return "testplan";
		}else if(ele instanceof AbstractThreadGroup) {
			return "thread-group";
		}else if(ele instanceof Timer) {
			return "timer";
		}else if(ele instanceof WorkBench) {
			return "workbench";
		}else {
			return "unknown";
		}
	}

}
