package org.apache.jmeter.modifiers;

import org.apache.jmeter.modifiers.model.*;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.cloudmeter.test.ModelTester;
import org.junit.Assert;
import org.junit.Test;

public class ModiferModelTest {

	
	@Test
	public void counterConfigTest() {
		CounterConfigInitializer initer = new CounterConfigInitializer();
		CounterConfig ele = (CounterConfig) initer.initilizeElement();
		
		ModelTester.testBasicFields("Counter", ele);
		
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
		
		ModelTester.testBasicFields("BeanShell PreProcessor", ele);
		Assert.assertSame("", ele.getFilename());
		Assert.assertSame("", ele.getParameters());
		Assert.assertFalse(ele.isResetInterpreter());
		Assert.assertSame("", ele.getScript());
	
	}
	
	@Test
	public void JSR223PreProcessorTest() {
		JSR223PreProcessorInitializer initer = new JSR223PreProcessorInitializer();
		JSR223PreProcessor ele = (JSR223PreProcessor) initer.initilizeElement();
		
		ModelTester.testBasicFields("JSR223 PreProcessor", ele);
		ModelTester.testBasicScriptFields("groovy", ele);
		
		Assert.assertSame("", ele.getCacheKey());
	}
	
	@Test
	public void sampleTimeoutTest() {
		SampleTimeoutInitializer initer = new SampleTimeoutInitializer();
		SampleTimeout ele = (SampleTimeout) initer.initilizeElement();
		ModelTester.testBasicFields("Sample Timeout", ele);
		
		Assert.assertTrue(ele.getTimeout() == 10000);
	}
	
	@Test
	public void UserParametersTest() {
		UserParametersInitializer initer = new UserParametersInitializer();
		UserParameters ele = (UserParameters) initer.initilizeElement();
		ModelTester.testBasicFields("User Parameters", ele);
		
		Assert.assertFalse(ele.isPerIteration());
		
		this.collectionCompare(
				this.createNewCollectionProperty(UserParameters.NAMES), 
				ele.getNames());
		this.collectionCompare(
				this.createNewCollectionProperty(UserParameters.THREAD_VALUES), 
				ele.getThreadLists());
		
	}
	
	

	
	private void collectionCompare(CollectionProperty expected, CollectionProperty actual) {
		Assert.assertSame(expected.getName(), actual.getName());
		Assert.assertTrue(expected.size() == actual.size());
		
		for(int i = 0; i < expected.size(); i++) {
			Assert.assertSame(expected.get(i), actual.get(i));
		}
	}
	
	private CollectionProperty createNewCollectionProperty(String name) {
		CollectionProperty prop = new CollectionProperty();
		prop.setName(name);
		
		return prop;
	}
	
}
