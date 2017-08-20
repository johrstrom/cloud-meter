package org.apache.jmeter.timers;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.timers.model.*;
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
		
		Assert.assertSame("300",ele.getDelay());
		Assert.assertEquals(0.0, ele.getRange(), 0.01);
	}

	
	private void baseModelAssertions(String expectedName, TestElement ele) {
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertSame(expectedName, ele.getName());
	}
	
}
