package org.apache.jmeter.config;

import org.apache.jmeter.config.model.*;
import org.cloudmeter.test.ModelTester;
import org.junit.Assert;
import org.junit.Test;

public class ConfigModelTest {
	
	@Test
	public void csvDataSetTest() {
		CSVDataSetInitializer initer = new CSVDataSetInitializer();
		CSVDataSet ele = (CSVDataSet) initer.initilizeElement();
	
		ModelTester.testBasicFields("CSV Data Set Config", ele);
		
		Assert.assertTrue(",".equals(ele.getDelimiter()));
		Assert.assertTrue("".equals(ele.getFileEncoding()));
		Assert.assertTrue("".equals(ele.getFilename()));
		Assert.assertFalse(ele.getQuotedData());
		Assert.assertTrue(ele.getRecycle());
		Assert.assertTrue("shareMode.all".equals(ele.getShareMode()));
		Assert.assertFalse(ele.getStopThread());
		Assert.assertTrue("".equals(ele.getVariableNames()));
	}
	
	@Test
	public void keystoreConfigTest() {
		KeystoreConfigInitializer initer = new KeystoreConfigInitializer();
		KeystoreConfig ele = (KeystoreConfig) initer.initilizeElement();
	
		ModelTester.testBasicFields("Keystore Configuration", ele);
		
		Assert.assertTrue("".equals(ele.getClientCertAliasVarName()));
		Assert.assertTrue("".equals(ele.getEndIndex()));
		Assert.assertTrue("".equals(ele.getStartIndex()));
		Assert.assertTrue(ele.isPreload());
		
	}

	@Test
	public void randomValueConfigTest() {
		RandomVariableConfigInitializer initer = new RandomVariableConfigInitializer();
		RandomVariableConfig ele = (RandomVariableConfig) initer.initilizeElement();
	
		ModelTester.testBasicFields("Random Variable", ele);
		
		Assert.assertSame("1", ele.getMinimumValue());
		Assert.assertSame("", ele.getMaximumValue());
		Assert.assertSame("", ele.getOutputFormat());
		Assert.assertFalse(ele.getPerThread());
		Assert.assertSame("", ele.getRandomSeed());
		Assert.assertSame("", ele.getVariableName());		
	}
	
	@Test
	public void simpleConfigTest() {
		SimpleConfigInitializer initer = new SimpleConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
	
		ModelTester.testBasicFields("Simple Config Element", ele);
	}
	
}
