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
	
		
	}
	
}
