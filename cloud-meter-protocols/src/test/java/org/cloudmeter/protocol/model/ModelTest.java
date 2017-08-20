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
import org.apache.jmeter.protocol.tcp.sampler.TCPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

	
	
	@Test
	public void httpSamplerTest() {
		HTTPSamplerInitializer initer = new HTTPSamplerInitializer();
		HTTPSamplerProxy ele = (HTTPSamplerProxy) initer.initilizeElement();
		
		this.baseModelAssertions("HTTP Request", ele);
	}
	
	
	@Test
	public void authManagerTest() {
		AuthManagerInitializer initer = new AuthManagerInitializer();
		AuthManager ele = (AuthManager) initer.initilizeElement();
		
		this.baseModelAssertions("HTTP Authorization Manager", ele);
		
		Assert.assertTrue(ele.getAuthCount() == 0);
		Assert.assertTrue(ele.isEditable());
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertTrue(ele.getColumnCount() == 6);
	}
	
	
	@Test
	public void httpCacheTest() {
		CacheManagerInitializer initer = new CacheManagerInitializer();
		CacheManager ele = (CacheManager) initer.initilizeElement();
			
		this.baseModelAssertions("HTTP Cache Manager", ele);
		
		Assert.assertTrue(ele.getMaxSize() == 5000);
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertFalse(ele.getUseExpires());
		
	}

	
	@Test
	public void httpCookieTest() {
		CookieManagerInitializer initer = new CookieManagerInitializer();
		CookieManager ele = (CookieManager) initer.initilizeElement();

		this.baseModelAssertions("HTTP Cookie Manager", ele);
		
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertTrue("org.apache.jmeter.protocol.http.control.HC4CookieHandler".equals(ele.getImplementation()));
		Assert.assertTrue("standard".equals(ele.getPolicy()));
		Assert.assertTrue(ele.getCookieCount() == 0);
	}
	
	@Test
	public void ftpConfigTest() {
		FTPConfigInitializer initer = new FTPConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		this.baseModelAssertions("FTP Request Defaults", ele);
		
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
		
		this.baseModelAssertions("HTTP Header Manager", ele);
	}
	
	@Test
	public void httpDefaultsTest() {
		HTTPDefaultsInitializer initer = new HTTPDefaultsInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		this.baseModelAssertions("HTTP Request Defaults", ele);
		
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
		
		this.baseModelAssertions("Java Request Defaults", ele);
		
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
		
		this.baseModelAssertions("JDBC Connection Configuration", ele);
	
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
	
	@Test
	public void ldapExtendedConfigTest() {
		LDAPExtendedConfigInitializer initer = new LDAPExtendedConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		this.baseModelAssertions("LDAP Extended Request Defaults", ele);
		
		Assert.assertSame("",ele.getPropertyAsString("attributes"));
		Assert.assertSame("",ele.getPropertyAsString("comparedn"));
		Assert.assertSame("",ele.getPropertyAsString("comparefilt"));
		Assert.assertSame("",ele.getPropertyAsString("connection_timeout"));
		Assert.assertSame("",ele.getPropertyAsString("countlimit"));
		Assert.assertFalse(ele.getPropertyAsBoolean("deref_aliases"));
		Assert.assertSame("",ele.getPropertyAsString("modddn"));
		Assert.assertSame("",ele.getPropertyAsString("newdn"));
		Assert.assertFalse(ele.getPropertyAsBoolean("parseflag"));
		Assert.assertSame("",ele.getPropertyAsString("port"));
		Assert.assertFalse(ele.getPropertyAsBoolean("return_object"));
		Assert.assertSame("",ele.getPropertyAsString("rootdn"));
		Assert.assertTrue(ele.getPropertyAsInt("scope") ==  2);
		Assert.assertFalse("",ele.getPropertyAsBoolean("secure"));
		Assert.assertSame("",ele.getPropertyAsString("servername"));
		Assert.assertSame("",ele.getPropertyAsString("timelimit"));
		Assert.assertSame("",ele.getPropertyAsString("user_dn"));
		Assert.assertSame("",ele.getPropertyAsString("user_pw"));
	}
	
	
	@Test
	public void ldapConfigTest() {
		LDAPConfigInitializer initer = new LDAPConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		this.baseModelAssertions("LDAP Request Defaults", ele);
		
		Assert.assertSame("",ele.getPropertyAsString("attributes"));
		Assert.assertSame("",ele.getPropertyAsString("base_entry_dn"));
		Assert.assertSame("",ele.getPropertyAsString("port"));
		Assert.assertSame("",ele.getPropertyAsString("rootdn"));
		Assert.assertSame("",ele.getPropertyAsString("servername"));
		Assert.assertSame("add",ele.getPropertyAsString("test"));
		Assert.assertFalse(ele.getPropertyAsBoolean("user_defined"));
	}
	

	@Test
	public void tcpConfigTest() {
		TCPConfigInitializer initer = new TCPConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		this.baseModelAssertions("TCP Sampler Config", ele);
		
		Assert.assertFalse(ele.getPropertyAsBoolean(TCPSampler.CLOSE_CONNECTION));
		Assert.assertFalse(ele.getPropertyAsBoolean(TCPSampler.NODELAY));
		Assert.assertTrue(ele.getPropertyAsInt(TCPSampler.PORT) == 0);
		Assert.assertTrue(ele.getPropertyAsBoolean(TCPSampler.RE_USE_CONNECTION));
		Assert.assertSame("", ele.getPropertyAsString(TCPSampler.REQUEST));
		Assert.assertSame("", ele.getPropertyAsString(TCPSampler.SERVER));
		Assert.assertTrue(ele.getPropertyAsInt(TCPSampler.TIMEOUT) == 0);
	}
	

	
	private void baseModelAssertions(String expectedName, TestElement ele) {
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertSame(expectedName, ele.getName());
	}

	
}
