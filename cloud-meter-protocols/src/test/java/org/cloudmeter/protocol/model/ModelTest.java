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
