package org.apache.jmeter.control.model;

import org.apache.jmeter.control.ForeachController;
import org.junit.Test;

import org.junit.Assert;

public class ForeachControllerInitializerTest {
	
	ForeachControllerInitializer initer = new ForeachControllerInitializer();

	
	@Test
	public void initTest() {
		ForeachController ele = (ForeachController) initer.initilizeElement();
				
		Assert.assertFalse(ele.isDone());
		Assert.assertTrue("".equals(ele.getStartIndexAsString()));
		Assert.assertTrue("".equals(ele.getEndIndexAsString()));
		Assert.assertTrue("".equals(ele.getReturnValString()));
		Assert.assertTrue("".equals(ele.getInputValString()));
		Assert.assertTrue(ele.getUseSeparator());
	
	}
	
}


