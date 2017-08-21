package org.apache.jmeter.modifiers;

import org.apache.jmeter.modifiers.model.BeanShellPreProcessorInitializer;
import org.apache.jmeter.modifiers.model.CounterConfigInitializer;
import org.apache.jmeter.testelement.TestElement;
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
	
	@Test
	public void beanShellTest() {
		BeanShellPreProcessorInitializer initer = new BeanShellPreProcessorInitializer();
		BeanShellPreProcessor ele = (BeanShellPreProcessor) initer.initilizeElement();
		
		this.baseModelAssertions("BeanShell PreProcessor", ele);
		Assert.assertSame("", ele.getFilename());
		Assert.assertSame("", ele.getParameters());
		Assert.assertFalse(ele.isResetInterpreter());
		Assert.assertSame("", ele.getScript());
	
	}
	
	
	private void baseModelAssertions(String expectedName, TestElement ele) {
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertSame(expectedName, ele.getName());
	}
}
