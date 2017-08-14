package org.cloudmeter.protocol.model;

import org.apache.jmeter.protocol.http.control.*;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

	
	
	@Test
	public void httpSamplerTest() {
		HTTPSamplerInitializer initer = new HTTPSamplerInitializer();
		HTTPSamplerProxy ele = (HTTPSamplerProxy) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("HTTP Request".equals(ele.getName()));
		
	}
	
	
	@Test
	public void authManagerTest() {
		AuthManagerInitializer initer = new AuthManagerInitializer();
		AuthManager ele = (AuthManager) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("HTTP Authorization Manager".equals(ele.getName()));
		Assert.assertTrue(ele.getAuthCount() == 0);
		Assert.assertTrue(ele.isEditable());
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertTrue(ele.getColumnCount() == 6);
	}
	
	
	@Test
	public void httpCacheTest() {
		CacheManagerInitializer initer = new CacheManagerInitializer();
		CacheManager ele = (CacheManager) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("HTTP Cache Manager".equals(ele.getName()));
		Assert.assertTrue(ele.getMaxSize() == 5000);
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertFalse(ele.getUseExpires());
		
	}

	
	@Test
	public void httpCookieTest() {
		CookieManagerInitializer initer = new CookieManagerInitializer();
		CookieManager ele = (CookieManager) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("HTTP Cookie Manager".equals(ele.getName()));
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertTrue("org.apache.jmeter.protocol.http.control.HC4CookieHandler".equals(ele.getImplementation()));
		Assert.assertTrue("standard".equals(ele.getPolicy()));
		Assert.assertTrue(ele.getCookieCount() == 0);
	}
	
	
}
