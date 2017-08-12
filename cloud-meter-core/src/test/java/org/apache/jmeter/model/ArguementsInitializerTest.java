package org.apache.jmeter.model;

import org.apache.jmeter.config.model.ArguementsInitializer;
import org.apache.jmeter.testelement.TestElement;
import org.junit.Assert;
import org.junit.Test;

public class ArguementsInitializerTest {
	
	@Test
	public void testArgIniter() {
		ArguementsInitializer initer = new ArguementsInitializer();
		TestElement ele = initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("User Defined Variables".equals(ele.getName()));
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue(ele.getPropertyAsBoolean(TestElement.ENABLED));		
	}
	
	
}
