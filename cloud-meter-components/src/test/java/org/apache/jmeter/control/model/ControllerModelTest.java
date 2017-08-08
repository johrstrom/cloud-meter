package org.apache.jmeter.control.model;

import org.apache.jmeter.control.CriticalSectionController;
import org.apache.jmeter.control.ForeachController;
import org.junit.Test;

import org.junit.Assert;

public class ControllerModelTest {
	
	@Test
	public void testForEach() {
		ForeachControllerInitializer initer = new ForeachControllerInitializer();
		ForeachController ele = (ForeachController) initer.initilizeElement();
				
		Assert.assertFalse(ele.isDone());
		Assert.assertTrue("".equals(ele.getStartIndexAsString()));
		Assert.assertTrue("".equals(ele.getEndIndexAsString()));
		Assert.assertTrue("".equals(ele.getReturnValString()));
		Assert.assertTrue("".equals(ele.getInputValString()));
		Assert.assertTrue(ele.getUseSeparator());
	
	}
	
	
	@Test
	public void testCriticalSection() {
		CriticalSectionControllerInitializer initer = new CriticalSectionControllerInitializer();
		CriticalSectionController ele = (CriticalSectionController) initer.initilizeElement();
		
		Assert.assertTrue("global_lock".equals(ele.getLockName()));
	}
	
	@Test
	public void testIfController() {
		
	}
	
}


