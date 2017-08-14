package org.apache.jmeter.control.model;

import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.control.*;
import org.apache.jmeter.testelement.TestElement;
import org.junit.Assert;
import org.junit.Test;

public class ModelInitializerTest {
	
	
	@Test
	public void loopControllerTest() {
		LoopControllerInitializer initer = new LoopControllerInitializer();
		LoopController ele = (LoopController) initer.initilizeElement();
		
		Assert.assertTrue("Loop Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());		
		Assert.assertTrue(ele.getLoops() == 1);
		Assert.assertTrue(ele.getPropertyAsBoolean("LoopController.continue_forever"));
	}
	
	@Test
	public void transactionControllerTest() {
		TransactionControllerInitializer initer = new TransactionControllerInitializer();
		TransactionController ele = (TransactionController) initer.initilizeElement();
		
		Assert.assertTrue("Transaction Controller".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());	
		Assert.assertFalse(ele.isGenerateParentSample());
		Assert.assertFalse(ele.isIncludeTimers());
	}
	
	@Test
	public void argumentsIniterTest() {
		ArgumentsInitializer initer = new ArgumentsInitializer();
		TestElement ele = initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("User Defined Variables".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue(ele.getPropertyAsBoolean(TestElement.ENABLED));		
	}
	

}
