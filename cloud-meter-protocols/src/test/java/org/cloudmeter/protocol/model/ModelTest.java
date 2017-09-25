package org.cloudmeter.protocol.model;

import java.util.Map;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.ftp.sampler.FTPSampler;
import org.apache.jmeter.protocol.http.control.*;
import org.apache.jmeter.protocol.java.config.JavaConfig;
import org.apache.jmeter.protocol.java.sampler.JavaSampler;
import org.apache.jmeter.protocol.java.test.JavaTest;
import org.apache.jmeter.protocol.jdbc.AbstractJDBCTestElement;
import org.apache.jmeter.protocol.jdbc.config.DataSourceElement;
import org.apache.jmeter.protocol.jdbc.processor.JDBCPreProcessor;
import org.apache.jmeter.protocol.jdbc.sampler.JDBCSampler;
import org.apache.jmeter.protocol.ldap.sampler.LDAPExtSampler;
import org.apache.jmeter.protocol.ldap.sampler.LDAPSampler;
import org.apache.jmeter.protocol.model.*;
import org.apache.jmeter.protocol.tcp.sampler.TCPSampler;
import org.cloudmeter.test.ModelTester;
import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

	@Test
	public void authManagerTest() {
		AuthManagerInitializer initer = new AuthManagerInitializer();
		AuthManager ele = (AuthManager) initer.initilizeElement();
		
		ModelTester.testBasicFields("HTTP Authorization Manager", ele);
		
		Assert.assertTrue(ele.getAuthCount() == 0);
		Assert.assertTrue(ele.isEditable());
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertTrue(ele.getColumnCount() == 6);
	}
	

	
	@Test
	public void ftpConfigTest() {
		FTPConfigInitializer initer = new FTPConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		ModelTester.testBasicFields("FTP Request Defaults", ele);
		
		Assert.assertFalse(ele.getPropertyAsBoolean(FTPSampler.BINARY_MODE));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.REMOTE_FILENAME)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.INPUT_DATA)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.LOCAL_FILENAME)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.PORT)));
		Assert.assertFalse(ele.getPropertyAsBoolean(FTPSampler.SAVE_RESPONSE));
		Assert.assertTrue("".equals(ele.getPropertyAsString(FTPSampler.SERVER)));
		Assert.assertFalse(ele.getPropertyAsBoolean(FTPSampler.UPLOAD_FILE));
		
	}
	

	
	public void javaConfigTest() {
		JavaConfigInitializer initer = new JavaConfigInitializer();
		JavaConfig ele = (JavaConfig) initer.initilizeElement();
		
		ModelTester.testBasicFields("Java Request Defaults", ele);
		
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
		
		ModelTester.testBasicFields("JDBC Connection Configuration", ele);
	
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
		
		ModelTester.testBasicFields("LDAP Extended Request Defaults", ele);
		
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.ATTRIBS));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.COMPAREDN));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.COMPAREFILT));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.CONNTO));
		Assert.assertTrue(0 == ele.getPropertyAsLong(LDAPExtSampler.COUNTLIM));
		Assert.assertFalse(ele.getPropertyAsBoolean(LDAPExtSampler.DEREF));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.MODDDN));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.NEWDN));
		Assert.assertFalse(ele.getPropertyAsBoolean(LDAPExtSampler.PARSEFLAG));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.PORT));
		Assert.assertFalse(ele.getPropertyAsBoolean(LDAPExtSampler.RETOBJ));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.ROOTDN));
		Assert.assertTrue(ele.getPropertyAsInt(LDAPExtSampler.SCOPE) ==  2);
		Assert.assertFalse("",ele.getPropertyAsBoolean(LDAPExtSampler.SECURE));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.SERVERNAME));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.TIMELIM));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.USERDN));
		Assert.assertSame("",ele.getPropertyAsString(LDAPExtSampler.USERPW));
	}
	
	
	@Test
	public void ldapConfigTest() {
		LDAPConfigInitializer initer = new LDAPConfigInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		ModelTester.testBasicFields("LDAP Request Defaults", ele);
		
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
		
		ModelTester.testBasicFields("TCP Sampler Config", ele);
		
		Assert.assertFalse(ele.getPropertyAsBoolean(TCPSampler.CLOSE_CONNECTION));
		Assert.assertFalse(ele.getPropertyAsBoolean(TCPSampler.NODELAY));
		Assert.assertTrue(ele.getPropertyAsInt(TCPSampler.PORT) == 0);
		Assert.assertTrue(ele.getPropertyAsBoolean(TCPSampler.RE_USE_CONNECTION));
		Assert.assertSame("", ele.getPropertyAsString(TCPSampler.REQUEST));
		Assert.assertSame("", ele.getPropertyAsString(TCPSampler.SERVER));
		Assert.assertTrue(ele.getPropertyAsInt(TCPSampler.TIMEOUT) == 0);
	}
		
	@Test
	public void jdbcPreProcessorTest() {
		JDBCPreProcessorInitializer initer = new JDBCPreProcessorInitializer();
		JDBCPreProcessor ele = (JDBCPreProcessor) initer.initilizeElement();
		
		ModelTester.testBasicFields("JDBC PreProcessor", ele);
		this.baseJDBCAssertions(ele);
	}
	
	@Test
	public void javaSamplerTest() {
		JavaSamplerInitializer initer = new JavaSamplerInitializer();
		JavaSampler ele = (JavaSampler) initer.initilizeElement();
		
		ModelTester.testBasicFields("Java Request", ele);
		
		Assert.assertSame(JavaTest.class.getName(),ele.getClassname());
		
		Map<String, String> args = ele.getArguments().getArgumentsAsMap();
		Assert.assertSame(args.get("Label"),"");
		Assert.assertSame(args.get("ResponseCode"), "");
		Assert.assertSame(args.get("ResponseMessage"), "");
		Assert.assertSame(args.get("ResultData"), "");
		Assert.assertSame(args.get("SamplerData"), "");
		Assert.assertSame(args.get("Sleep_Mask"), "0xFF");
		Assert.assertSame(args.get("Sleep_Time"), "100");
		Assert.assertSame(args.get("Status"), "OK");		
	}
	
	@Test
	public void jdbcSamplerTest() {
		JDBCSamplerInitializer initer = new JDBCSamplerInitializer();
		JDBCSampler ele = (JDBCSampler) initer.initilizeElement();
		
		ModelTester.testBasicFields("JDBC Request", ele);
		this.baseJDBCAssertions(ele);
	}
	
	@Test
	public void ldapExtSamplerTest() {
		
		LDAPExtSamplerInitializer initer = new LDAPExtSamplerInitializer();
		LDAPExtSampler ele = (LDAPExtSampler) initer.initilizeElement();
		
		ModelTester.testBasicFields("LDAP Extended Request", ele);
		
		Assert.assertSame("", ele.getAttrs());
		Assert.assertSame("", ele.getPropertyAsString(LDAPExtSampler.COMPAREDN));
		Assert.assertSame("", ele.getPropertyAsString(LDAPExtSampler.COMPAREFILT));
		Assert.assertSame("", ele.getConnTimeOut());
		Assert.assertFalse(ele.isDeref());
		Assert.assertSame("", ele.getPropertyAsString(LDAPExtSampler.MODDDN));
		Assert.assertSame("", ele.getPropertyAsString(LDAPExtSampler.NEWDN));
		Assert.assertFalse(ele.isParseFlag());
		Assert.assertSame("", ele.getPort());
		Assert.assertFalse(ele.isRetobj());
		Assert.assertSame("", ele.getRootdn());
		Assert.assertTrue(2 == ele.getScope());
		Assert.assertFalse(ele.isSecure());
		Assert.assertSame("", ele.getServername());
		Assert.assertTrue(0 == ele.getTimelim());
		Assert.assertSame("", ele.getUserDN());
		Assert.assertSame("", ele.getUserPw());
		Assert.assertTrue(0 == ele.getCountlim());		
	}
	
	@Test
	public void ldapSamplerTest() {	
		LDAPSamplerInitializer initer = new LDAPSamplerInitializer();
		LDAPSampler ele = (LDAPSampler) initer.initilizeElement();
		
		ModelTester.testBasicFields("LDAP Request", ele);
		
		Assert.assertSame("",ele.getPropertyAsString(ConfigTestElement.USERNAME));
		Assert.assertSame("",ele.getPropertyAsString(ConfigTestElement.PASSWORD));
		Assert.assertSame("",ele.getBaseEntryDN());
		Assert.assertSame("",ele.getPort());
		Assert.assertSame("",ele.getRootdn());
		Assert.assertSame("",ele.getServername());
		Assert.assertSame("add",ele.getTest());
		Assert.assertFalse(ele.getUserDefinedTest());
		
	}
	
	private void baseJDBCAssertions(AbstractJDBCTestElement ele) {
		Assert.assertSame("Select Statement", ele.getQueryType());
		Assert.assertSame("Store as String", ele.getResultSetHandler());
		Assert.assertTrue(ele.getQueryTimeout() == 0);
		
		Assert.assertSame("", ele.getDataSource());
		Assert.assertSame("", ele.getQuery());
		Assert.assertSame("", ele.getQueryArguments());
		Assert.assertSame("", ele.getQueryArgumentsTypes());
		Assert.assertSame("", ele.getVariableNames());
		Assert.assertSame("", ele.getResultVariable());		
	}
	
}
