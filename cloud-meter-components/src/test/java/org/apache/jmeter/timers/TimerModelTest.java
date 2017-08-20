package org.apache.jmeter.timers;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.model.*;
import org.apache.jmeter.util.ScriptingTestElement;
import org.junit.Assert;
import org.junit.Test;

public class TimerModelTest {
	
	
	@Test
	public void beanShellTest() {
		BeanShellTimerInitializer initer = new BeanShellTimerInitializer();
		BeanShellTimer ele = (BeanShellTimer) initer.initilizeElement();
		
		this.baseModelAssertions("BeanShell Timer", ele);
		Assert.assertSame("", ele.getFilename());
		Assert.assertSame("", ele.getParameters());
		Assert.assertFalse(ele.isResetInterpreter());
		Assert.assertSame("", ele.getScript());
	
	}
	
	@Test
	public void constantThroughputTimerTest() {
		ConstantThroughputTimerInitializer initer = new ConstantThroughputTimerInitializer();
		ConstantThroughputTimer ele = (ConstantThroughputTimer) initer.initilizeElement();
		
		this.baseModelAssertions("Constant Throughput Timer", ele);
		
		Assert.assertTrue(ele.getCalcMode() == 0);
		Assert.assertEquals(0.0, ele.getThroughput(), 0.01);
	}
	
	@Test
	public void constantTimerTest() {
		ConstantTimerInitializer initer = new ConstantTimerInitializer();
		ConstantTimer ele = (ConstantTimer) initer.initilizeElement();
		
		this.baseModelAssertions("Constant Timer", ele);
		
		Assert.assertTrue(ele.getDelay() == 300);
		Assert.assertEquals(0.0, ele.getRange(), 0.01);
	}
	
	@Test
	public void gaussianRandomTimerTest() {
		GaussianRandomTimerInitializer initer = new GaussianRandomTimerInitializer();
		GaussianRandomTimer ele = (GaussianRandomTimer) initer.initilizeElement();
		
		this.baseModelAssertions("Gaussian Random Timer", ele);
		
		Assert.assertTrue(ele.getDelay() == 300);
		Assert.assertEquals(100.0, ele.getRange(), 0.01);
	}

	@Test
	public void JSR223TimerTest() {
		JSR223TimerInitializer initer = new JSR223TimerInitializer();
		JSR223Timer ele = (JSR223Timer) initer.initilizeElement();
		
		this.baseModelAssertions("JSR223 Timer", ele);
		this.baseScriptingAssertions("groovy", ele);
		
		Assert.assertSame("", ele.getCacheKey());
		
	}
	
	@Test
	public void poissonRandomTimerTest() {
		PoissonRandomTimerInitializer initer = new PoissonRandomTimerInitializer();
		PoissonRandomTimer ele = (PoissonRandomTimer) initer.initilizeElement();
		
		this.baseModelAssertions("Poisson Random Timer", ele);
		
		Assert.assertTrue(ele.getDelay() == 300);
		Assert.assertEquals(100.0, ele.getRange(), 0.01);
	}
	
	@Test
	public void synchronizationTimerTest() {
		SyncTimerInitializer initer = new SyncTimerInitializer();
		SyncTimer ele = (SyncTimer) initer.initilizeElement();
		
		this.baseModelAssertions("Synchronizing Timer", ele);
		
		Assert.assertTrue(ele.getGroupSize() == 0);
		Assert.assertTrue(ele.getTimeoutInMs() == 0);
	}
	
	@Test
	public void uniformRandomTimerTest() {
		UniformRandomTimerInitializer initer = new UniformRandomTimerInitializer();
		UniformRandomTimer ele = (UniformRandomTimer) initer.initilizeElement();
		
		this.baseModelAssertions("Uniform Random Timer", ele);
		
		Assert.assertTrue(ele.getDelay() == 0);
		Assert.assertEquals(100.0, ele.getRange(), 0.01);
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
