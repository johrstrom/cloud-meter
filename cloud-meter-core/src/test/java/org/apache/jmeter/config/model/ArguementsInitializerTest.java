package org.apache.jmeter.config.model;

import org.apache.jmeter.testelement.TestElement;
import org.junit.Assert;
import org.junit.Test;

public class ArguementsInitializerTest {

	
	
	private ArguementsInitializer initer = new ArguementsInitializer();
	
	@Test
	public void foo() {
		TestElement ele = initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ArguementsInitializer.DEFAULT_NAME.equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue(ele.getPropertyAsBoolean(TestElement.ENABLED));
		Assert.assertEquals(
				ele.getPropertyAsString(TestElement.MODEL_INITIALIZER), 
				initer.getClass().getName());
		
	}
	
	
}
