package org.apache.jmeter.modifiers;

import org.apache.jmeter.modifiers.model.*;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.ScriptingTestElement;
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
	
	@Test
	public void JSR223PreProcessorTest() {
		JSR223PreProcessorInitializer initer = new JSR223PreProcessorInitializer();
		JSR223PreProcessor ele = (JSR223PreProcessor) initer.initilizeElement();
		
		this.baseModelAssertions("JSR223 PreProcessor", ele);
		this.baseScriptingAssertions("groovy", ele);
		
		Assert.assertSame("", ele.getCacheKey());
	}
	
	private void baseModelAssertions(String expectedName, TestElement ele) {
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertSame(expectedName, ele.getName());
	}
	
	private void baseScriptingAssertions(String expectedLanguage, ScriptingTestElement ele) {
		Assert.assertSame("", ele.getFilename());
		Assert.assertSame("", ele.getParameters());
		Assert.assertSame("", ele.getScript());
		Assert.assertSame(expectedLanguage, ele.getScriptLanguage());
	}
	
}
