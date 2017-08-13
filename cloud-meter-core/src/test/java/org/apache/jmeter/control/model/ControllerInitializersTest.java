package org.apache.jmeter.control.model;

import org.apache.jmeter.control.*;
import org.junit.Assert;
import org.junit.Test;

public class ControllerInitializersTest {
	
	
	@Test
	public void loopControllerTest() {
		LoopControllerInitializer initer = new LoopControllerInitializer();
		LoopController ele = (LoopController) initer.initilizeElement();
		
		Assert.assertTrue("Loop Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());		
		Assert.assertTrue(ele.getLoops() == 1);
		Assert.assertTrue(ele.getPropertyAsBoolean("LoopController.continue_forever"));
	}

}
