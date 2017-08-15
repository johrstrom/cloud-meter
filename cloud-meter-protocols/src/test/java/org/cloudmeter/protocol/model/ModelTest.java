package org.cloudmeter.protocol.model;

import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.ftp.sampler.FTPSampler;
import org.apache.jmeter.protocol.http.control.*;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.java.config.JavaConfig;
import org.apache.jmeter.protocol.jdbc.config.DataSourceElement;
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
	
	@Test
	public void ftpConfigTest() {
		FTPConfigInitializer initer = new FTPConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue("FTP Request Defaults".equals(ele.getName()));
		Assert.assertFalse(ele.getPropertyAsBoolean(FTPSampler.BINARY_MODE));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.REMOTE_FILENAME)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.INPUT_DATA)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.LOCAL_FILENAME)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.PORT)));
		Assert.assertFalse(ele.getPropertyAsBoolean(FTPSampler.SAVE_RESPONSE));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.SERVER)));
		Assert.assertFalse(ele.getPropertyAsBoolean(FTPSampler.UPLOAD_FILE));
		
	}
	
	@Test
	public void headerManagerTest() {
		HeaderManagerInitializer initer = new HeaderManagerInitializer();
		HeaderManager ele = (HeaderManager) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue("HTTP Header Manager".equals(ele.getName()));
		
	}
	
	@Test
	public void httpDefaultsTest() {
		HTTPDefaultsInitializer initer = new HTTPDefaultsInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue("HTTP Request Defaults".equals(ele.getName()));
		Assert.assertTrue("6".equals(ele.getPropertyAsString(HTTPSampler.CONCURRENT_POOL)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.CONNECT_TIMEOUT)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.CONTENT_ENCODING)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.DOMAIN)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.PATH)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.PORT)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.PROTOCOL)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.RESPONSE_TIMEOUT)));
		Assert.assertTrue(ele.getProperty(HTTPSampler.ARGUMENTS) != null);		
		
	}
	
	public void javaConfigTest() {
		JavaConfigInitializer initer = new JavaConfigInitializer();
		JavaConfig ele = (JavaConfig) initer.initilizeElement();
		

		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue("Java Request Defaults".equals(ele.getName()));
		Assert.assertTrue("org.apache.jmeter.protocol.java.test.JavaTest"
				.equals(ele.getPropertyAsString("classname")));
		
		Arguments args = ele.getArguments();
		Assert.assertTrue(args.getArgumentCount() == 8);
		Map<String, String> argMap = args.getArgumentsAsMap();
		
		Assert.assertTrue("".equals(argMap.get("Label")));
		Assert.assertTrue("".equals(argMap.get("ResponseMessage")));
		Assert.assertTrue("".equals(argMap.get("ResponseCode")));
		Assert.assertTrue("".equals(argMap.get("ResultData")));
		Assert.assertTrue("".equals(argMap.get("SamplerData")));
		Assert.assertTrue("0xFF".equals(argMap.get("Sleep_Mask")));
		Assert.assertTrue("100".equals(argMap.get("Sleep_Time")));
		Assert.assertTrue("OK".equals(argMap.get("Status")));
			
	}
	
	
	@Test
	public void jdbcConfigTest() {
		JDBCConfigInitializer initer = new JDBCConfigInitializer();
		DataSourceElement ele = (DataSourceElement) initer.initilizeElement();
		
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue("JDBC Connection Configuration".equals(ele.getName()));
		
		
		Assert.assertTrue(ele.isAutocommit());
		Assert.assertTrue("Select 1".equals(ele.getCheckQuery()));
		Assert.assertTrue("5000".equals(ele.getConnectionAge()));
		Assert.assertTrue("".equals(ele.getDataSource()));
		Assert.assertTrue("".equals(ele.getDbUrl()));
		Assert.assertTrue("".equals(ele.getDriver()));
		Assert.assertTrue(ele.isKeepAlive());
		Assert.assertTrue("".equals(ele.getPassword()));
		Assert.assertTrue("10".equals(ele.getPoolMax()));
		Assert.assertTrue("10000".equals(ele.getTimeout()));
		Assert.assertTrue("DEFAULT".equals(ele.getTransactionIsolation()));
		Assert.assertTrue("60000".equals(ele.getTrimInterval()));
		Assert.assertTrue("".equals(ele.getUsername()));
		
	}
	
}
