package org.apache.jmeter.control;

import org.apache.jmeter.control.model.*;
import org.cloudmeter.test.ModelTester;
import org.junit.Test;

import org.junit.Assert;

public class ControllerModelTest {
	
	@Test
	public void forEachTest() {
		ForeachControllerInitializer initer = new ForeachControllerInitializer();
		ForeachController ele = (ForeachController) initer.initilizeElement();
		
		ModelTester.testBasicFields("ForEach Controller", ele);
		
		Assert.assertFalse(ele.isDone());
		Assert.assertTrue("".equals(ele.getStartIndexAsString()));
		Assert.assertTrue("".equals(ele.getEndIndexAsString()));
		Assert.assertTrue("".equals(ele.getReturnValString()));
		Assert.assertTrue("".equals(ele.getInputValString()));
		Assert.assertTrue(ele.getUseSeparator());
	}
	
	
	@Test
	public void criticalSectionTest() {
		CriticalSectionControllerInitializer initer = new CriticalSectionControllerInitializer();
		CriticalSectionController ele = (CriticalSectionController) initer.initilizeElement();
		
		ModelTester.testBasicFields("Critical Section Controller", ele);
		
		Assert.assertTrue("global_lock".equals(ele.getLockName()));
	}
	
	@Test
	public void ifControllerTest() {
		IfControllerInitializer initer = new IfControllerInitializer();
		IfController ele = (IfController) initer.initilizeElement();
		
		ModelTester.testBasicFields("If Controller", ele);
		
		Assert.assertTrue("".equals(ele.getCondition()));
		Assert.assertFalse(ele.isEvaluateAll());
	}
	
	@Test
	public void includeControllerTest() {
		IncludeControllerInitializer initer = new IncludeControllerInitializer();
		IncludeController ele = (IncludeController) initer.initilizeElement();
		
		ModelTester.testBasicFields("Include Controller", ele);
		
		Assert.assertTrue("".equals(ele.getIncludePath()));	
	}
	
	@Test
	public void onceOnlyControllerTest() {
		OnceOnlyControllerInitializer initer = new OnceOnlyControllerInitializer();
		OnceOnlyController ele = (OnceOnlyController) initer.initilizeElement();
		
		ModelTester.testBasicFields("Once Only Controller", ele);
	}
	
	@Test
	public void randomControllerTest() {
		RandomControllerInitializer initer = new RandomControllerInitializer();
		RandomController ele = (RandomController) initer.initilizeElement();
		
		ModelTester.testBasicFields("Random Controller", ele);
		
		Assert.assertTrue(ele.getStyle() == 1);
	}

	
	@Test
	public void randomOrderControllerTest() {
		RandomOrderControllerInitializer initer = new RandomOrderControllerInitializer();
		RandomOrderController ele = (RandomOrderController) initer.initilizeElement();
		
		ModelTester.testBasicFields("Random Order Controller", ele);
	}
	
	@Test
	public void switchControllerTest() {
		SwitchControllerInitializer initer = new SwitchControllerInitializer();
		SwitchController ele = (SwitchController) initer.initilizeElement();
		
		ModelTester.testBasicFields("Switch Controller", ele);
		
		Assert.assertTrue("".equals(ele.getSelection()));	
	}
	
	@Test
	public void throughputControllerTest() {
		ThroughputControllerInitializer initer = new ThroughputControllerInitializer();
		ThroughputController ele = (ThroughputController) initer.initilizeElement();
		
		ModelTester.testBasicFields("Throughput Controller", ele);
			
		Assert.assertTrue("1".equals(ele.getMaxThroughput()));
		Assert.assertFalse(ele.isPerThread());
		Assert.assertTrue("1.0".equals(ele.getPercentThroughput()));
		Assert.assertTrue(ele.getStyle() == 1);
	}
	
	@Test
	public void whileControllerTest() {
		WhileControllerInitializer initer = new WhileControllerInitializer();
		WhileController ele = (WhileController) initer.initilizeElement();
		
		ModelTester.testBasicFields("While Controller", ele);
			
		Assert.assertTrue("".contentEquals(ele.getCondition()));
	}
	
}


