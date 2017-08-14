package org.apache.jmeter.config.model;

import org.apache.jmeter.config.*;
import org.junit.Assert;
import org.junit.Test;

public class ConfigModelTest {
	
	@Test
	public void csvDataSetTest() {
		CSVDataSetInitializer initer = new CSVDataSetInitializer();
		CSVDataSet ele = (CSVDataSet) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue("CSV Data Set Config".equals(ele.getName()));
		Assert.assertTrue(",".equals(ele.getDelimiter()));
		Assert.assertTrue("".equals(ele.getFileEncoding()));
		Assert.assertTrue("".equals(ele.getFilename()));
		Assert.assertFalse(ele.getQuotedData());
		Assert.assertTrue(ele.getRecycle());
		Assert.assertTrue("shareMode.all".equals(ele.getShareMode()));
		Assert.assertFalse(ele.getStopThread());
		Assert.assertTrue("".equals(ele.getVariableNames()));
	}

}
