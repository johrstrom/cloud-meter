package org.apache.jmeter.model;

import org.apache.jmeter.config.model.*;
import org.apache.jmeter.control.*;
import org.apache.jmeter.control.model.*;
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
	public void argumentsConfigIniterTest() {
		ArgumentsInitializer initer = new ArgumentsInitializer();
		TestElement ele = initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("User Defined Variables".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue(ele.getPropertyAsBoolean(TestElement.ENABLED));		
	}
	
	@Test
	public void loginConfigIniterTest() {
		LoginConfigInitializer initer = new LoginConfigInitializer();
		TestElement ele = initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("Login Config Element".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue(ele.getPropertyAsBoolean(TestElement.ENABLED));
		Assert.assertTrue("".equals(ele.getPropertyAsString("ConfigTestElement.password")));	
		Assert.assertTrue("".equals(ele.getPropertyAsString("ConfigTestElement.username")));	
	}
	

}
