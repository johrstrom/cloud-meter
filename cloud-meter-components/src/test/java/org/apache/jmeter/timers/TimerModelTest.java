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

	
	private void baseModelAssertions(String expectedName, TestElement ele) {
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertSame(expectedName, ele.getName());
	}
	
}
