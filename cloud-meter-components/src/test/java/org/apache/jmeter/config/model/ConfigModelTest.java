package org.apache.jmeter.config.model;

import org.apache.jmeter.config.*;
import org.apache.jmeter.testelement.TestElement;
import org.junit.Assert;
import org.junit.Test;

public class ConfigModelTest {
	
	@Test
	public void csvDataSetTest() {
		CSVDataSetInitializer initer = new CSVDataSetInitializer();
		CSVDataSet ele = (CSVDataSet) initer.initilizeElement();
	
		this.baseModelAssertions("CSV Data Set Config", ele);
		
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
	
		this.baseModelAssertions("Keystore Configuration", ele);
		
		Assert.assertTrue("".equals(ele.getClientCertAliasVarName()));
		Assert.assertTrue("".equals(ele.getEndIndex()));
		Assert.assertTrue("".equals(ele.getStartIndex()));
		Assert.assertTrue(ele.isPreload());
		
	}

	@Test
	public void randomValueConfigTest() {
		RandomVariableConfigInitializer initer = new RandomVariableConfigInitializer();
		RandomVariableConfig ele = (RandomVariableConfig) initer.initilizeElement();
	
		this.baseModelAssertions("Random Variable", ele);
		
		Assert.assertSame("1", ele.getMinimumValue());
		Assert.assertSame("", ele.getMaximumValue());
		Assert.assertSame("", ele.getOutputFormat());
		Assert.assertFalse(ele.getPerThread());
		Assert.assertSame("", ele.getRandomSeed());
		Assert.assertSame("", ele.getVariableName());		
	}
	
	private void baseModelAssertions(String expectedName, TestElement ele) {
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertSame(expectedName, ele.getName());
	}
	
}
