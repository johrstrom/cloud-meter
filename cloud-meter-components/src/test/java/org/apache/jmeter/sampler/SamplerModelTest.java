package org.apache.jmeter.sampler;

import org.apache.jmeter.sampler.model.DebugSamplerInitializer;
import org.cloudmeter.test.ModelTester;
import org.junit.Assert;
import org.junit.Test;

public class SamplerModelTest {

	@Test
	public void debugInitializerTest() {
		DebugSamplerInitializer initer = new DebugSamplerInitializer();
		DebugSampler ele = (DebugSampler) initer.initilizeElement();
		
		ModelTester.testBasicFields("Debug Sampler", ele);
		
		Assert.assertTrue(ele.isDisplayJMeterVariables());
		Assert.assertFalse(ele.isDisplayJMeterProperties());
		Assert.assertFalse(ele.isDisplaySystemProperties());
		
	}
	
}
