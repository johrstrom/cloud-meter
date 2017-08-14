package org.apache.jmeter.modifiers.model;

import org.apache.jmeter.modifiers.CounterConfig;
import org.junit.Assert;
import org.junit.Test;

public class ModiferModelTest {

	
	@Test
	public void counterConfigTest() {
		CounterConfigInitializer initer = new CounterConfigInitializer();
		CounterConfig ele = (CounterConfig) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("Counter".equals(ele.getName()));
		Assert.assertTrue(ele.getEnd() == Long.MAX_VALUE);
		Assert.assertTrue(ele.getStart() == 0);
		Assert.assertTrue("".equals(ele.getFormat()));
		Assert.assertTrue("".equals(ele.getVarName()));
		Assert.assertFalse(ele.isPerUser());
		
	}
	
}
