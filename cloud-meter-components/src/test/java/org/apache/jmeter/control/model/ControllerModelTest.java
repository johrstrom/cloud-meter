package org.apache.jmeter.control.model;

import org.apache.jmeter.control.*;
import org.junit.Test;

import org.junit.Assert;

public class ControllerModelTest {
	
	@Test
	public void forEachTest() {
		ForeachControllerInitializer initer = new ForeachControllerInitializer();
		ForeachController ele = (ForeachController) initer.initilizeElement();
		
		Assert.assertTrue("ForEach Controller".equals(ele.getName()));	
		Assert.assertFalse(ele.isDone());
		Assert.assertTrue("".equals(ele.getStartIndexAsString()));
		Assert.assertTrue("".equals(ele.getEndIndexAsString()));
		Assert.assertTrue("".equals(ele.getReturnValString()));
		Assert.assertTrue("".equals(ele.getInputValString()));
		Assert.assertTrue(ele.getUseSeparator());
		Assert.assertTrue(ele.isEnabled());	
	}
	
	
	@Test
	public void criticalSectionTest() {
		CriticalSectionControllerInitializer initer = new CriticalSectionControllerInitializer();
		CriticalSectionController ele = (CriticalSectionController) initer.initilizeElement();
		
		Assert.assertTrue("Critical Section Controller".equals(ele.getName()));	
		Assert.assertTrue("global_lock".equals(ele.getLockName()));
		Assert.assertTrue(ele.isEnabled());	
	}
	
	@Test
	public void ifControllerTest() {
		IfControllerInitializer initer = new IfControllerInitializer();
		IfController ele = (IfController) initer.initilizeElement();
		
		Assert.assertTrue("If Controller".equals(ele.getName()));	
		Assert.assertTrue("".equals(ele.getCondition()));
		Assert.assertFalse(ele.isEvaluateAll());
		Assert.assertTrue(ele.isEnabled());	
	}
	
	@Test
	public void includeControllerTest() {
		IncludeControllerInitializer initer = new IncludeControllerInitializer();
		IncludeController ele = (IncludeController) initer.initilizeElement();
		
		Assert.assertTrue("Include Controller".equals(ele.getName()));	
		Assert.assertTrue("".equals(ele.getIncludePath()));	
		Assert.assertTrue(ele.isEnabled());	
	}
	
	@Test
	public void onceOnlyControllerTest() {
		OnceOnlyControllerInitializer initer = new OnceOnlyControllerInitializer();
		OnceOnlyController ele = (OnceOnlyController) initer.initilizeElement();
		
		Assert.assertTrue("Once Only Controller".equals(ele.getName()));	
		Assert.assertTrue(ele.isEnabled());	
	}
	
	@Test
	public void randomControllerTest() {
		RandomControllerInitializer initer = new RandomControllerInitializer();
		RandomController ele = (RandomController) initer.initilizeElement();
		
		Assert.assertTrue("Random Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());	
		Assert.assertTrue(ele.getStyle() == 1);
	}

	
	@Test
	public void randomOrderControllerTest() {
		RandomOrderControllerInitializer initer = new RandomOrderControllerInitializer();
		RandomOrderController ele = (RandomOrderController) initer.initilizeElement();
		
		Assert.assertTrue("Random Order Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());	
	}
	
	@Test
	public void switchControllerTest() {
		SwitchControllerInitializer initer = new SwitchControllerInitializer();
		SwitchController ele = (SwitchController) initer.initilizeElement();
		
		Assert.assertTrue("Switch Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());	
		Assert.assertTrue("".equals(ele.getSelection()));	
	}
	
	@Test
	public void throughputControllerTest() {
		ThroughputControllerInitializer initer = new ThroughputControllerInitializer();
		ThroughputController ele = (ThroughputController) initer.initilizeElement();
		
		Assert.assertTrue("Throughput Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());	
		Assert.assertTrue("1".equals(ele.getMaxThroughput()));
		Assert.assertFalse(ele.isPerThread());
		Assert.assertTrue("1.0".equals(ele.getPercentThroughput()));
		Assert.assertTrue(ele.getStyle() == 1);
	}
	
	@Test
	public void whileControllerTest() {
		WhileControllerInitializer initer = new WhileControllerInitializer();
		WhileController ele = (WhileController) initer.initilizeElement();
		
		Assert.assertTrue("While Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());	
		Assert.assertTrue("".contentEquals(ele.getCondition()));
	}
	
}


