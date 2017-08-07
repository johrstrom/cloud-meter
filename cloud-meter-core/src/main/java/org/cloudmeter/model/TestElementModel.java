package org.cloudmeter.model;

import org.apache.jmeter.assertions.Assertion;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.control.Controller;
import org.apache.jmeter.processor.PostProcessor;
import org.apache.jmeter.processor.PreProcessor;
import org.apache.jmeter.reporters.AbstractListenerElement;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.testelement.WorkBench;
import org.apache.jmeter.threads.AbstractThreadGroup;
import org.apache.jmeter.timers.Timer;
import org.apache.jorphan.collections.HashTree;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestElementModel {
	
	private TestElement testElement;
		
	private ModelType type;
	
	@JsonSerialize(using = HashTreeSerializer.class)
	private HashTree hashTree;
	
	public TestElement getTestElement() {
		return testElement;
	}
	
	public void setTestElement(TestElement testElement) {
		this.testElement = testElement;
	}
	
	public ModelType getType() {
		return type;
	}

	public void setType(ModelType modelType) {
		this.type = modelType;
	}

	public HashTree getHashTree() {
		return hashTree;
	}

	public void setHashTree(HashTree hashTree) {
		this.hashTree = hashTree;
	}
	
	public enum ModelType  {
		assertion,
		config,
		controller,
		listener,
		post_processor,
		pre_processor,
		sampler,
		testplan,
		thread_group,
		timer,
		workbench,
		unknown;
	}

	public static ModelType getElementType(Object ele) {
		//first be sure it's a test element
		if(!(ele instanceof TestElement)) 
			return ModelType.unknown;
		
		if (ele instanceof Assertion) {
			return ModelType.assertion;
		}else if (ele instanceof ConfigTestElement) { 
			return ModelType.config;
		}else if (ele instanceof Controller) {
			return ModelType.controller;
		}else if (ele instanceof AbstractListenerElement) {
			return ModelType.listener;
		}else if (ele instanceof PostProcessor ) {
			return ModelType.post_processor;
		}else if (ele instanceof PreProcessor ) {
			return ModelType.pre_processor;
		}else if (ele instanceof AbstractSampler) {
			return ModelType.sampler;
		}else if(ele instanceof TestPlan) {
			return ModelType.testplan;
		}else if(ele instanceof AbstractThreadGroup) {
			return ModelType.thread_group;
		}else if(ele instanceof Timer) {
			return ModelType.timer;
		}else if(ele instanceof WorkBench) {
			return ModelType.workbench;
		}else {
			return ModelType.unknown;
		}
	}
	

}
