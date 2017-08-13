package org.cloudmeter.service;

import org.cloudmeter.CloudMeterApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cloudmeter.test.TestUtilities;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CloudMeterApp.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NewElementTest {
	
	private static final String FILE_BASE = "target/test-classes/testelements";
	private static final String SAMPLER_BASE = FILE_BASE + "/samplers/";
	private static final String CONTROLLER_BASE = FILE_BASE + "/controllers/";
	private static final String CONFIG_BASE = FILE_BASE + "/config/";
	
	@Autowired
	private TestUtilities utilities;

	@LocalServerPort
	int port;
	
	
	@Before 
	public void setup() {
		utilities.setPort(port);
	}
	
	@Test
	public void HTTPSamplerTest() {
		utilities.validateFileAgainstAPI("http-sampler", SAMPLER_BASE + "http.json");
	}
	
	@Test
	public void criticalSectionControllerTest() {
		utilities.validateFileAgainstAPI("critical-section-controller", CONTROLLER_BASE + "critical-section.json");
	}
	
	@Test
	public void forEachControllerTest() {
		utilities.validateFileAgainstAPI("foreach-controller", CONTROLLER_BASE + "foreach.json");
	}
	
	
	@Test
	public void ifControllerTest() {
		utilities.validateFileAgainstAPI("if-controller", CONTROLLER_BASE + "if.json");
	}
	
	@Test
	public void includeControllerTest() {
		utilities.validateFileAgainstAPI("include-controller", CONTROLLER_BASE + "include.json");
	}
	
	
	@Test
	public void loopControllerTest() {
		utilities.validateFileAgainstAPI("loop-controller", CONTROLLER_BASE + "loop.json");
	}
	
	@Test
	public void onceOnlyControllerTest() {
		utilities.validateFileAgainstAPI("once-only-controller", CONTROLLER_BASE + "once-only.json");
	}
	
	@Test
	public void randomControllerTest() {
		utilities.validateFileAgainstAPI("random-controller", CONTROLLER_BASE + "random.json");
	}
	
	@Test
	public void randomOrderControllerTest() {
		utilities.validateFileAgainstAPI("random-order-controller", CONTROLLER_BASE + "random-order.json");
	}
	
	@Test
	public void switchControllerTest() {
		utilities.validateFileAgainstAPI("switch-controller", CONTROLLER_BASE + "switch.json");
	}
	
	
	@Test
	public void throughputControllerTest() {
		utilities.validateFileAgainstAPI("throughput-controller", CONTROLLER_BASE + "throughput.json");
	}
	
	@Test
	public void transactionControllerTest() {
		utilities.validateFileAgainstAPI("transaction-controller", CONTROLLER_BASE + "transaction.json");
	}
	
	@Test
	public void whileControllerTest() {
		utilities.validateFileAgainstAPI("while-controller", CONTROLLER_BASE + "while.json");
	}
	
	/**
	 * Controller tests end
	 * 
	 * Config tests begin
	 */
	
	@Test
	public void authConfigTest() {
		utilities.validateFileAgainstAPI("http-auth-config", CONFIG_BASE + "auth.json");
	}
	
	@Test
	public void cacheConfigTest() {
		utilities.validateFileAgainstAPI("http-cache-config", CONFIG_BASE + "cache.json");
	}
	
	@Test
	public void cookieConfigTest() {
		utilities.validateFileAgainstAPI("http-cookie-config", CONFIG_BASE + "cookie.json");
	}
	
	@Test
	public void counterConfigTest() {
		utilities.validateFileAgainstAPI("counter", CONFIG_BASE + "counter.json");
	}
	
	@Test
	public void csvDataSetTest() {
		utilities.validateFileAgainstAPI("csv-dataset", CONFIG_BASE + "csv-dataset.json");
	}
	
	@Test
	public void ftpConfigTest() {
		utilities.validateFileAgainstAPI("ftp-config", CONFIG_BASE + "ftp-config.json");
	}
	
	@Test
	public void httpDefaultConfigTest() {
		utilities.validateFileAgainstAPI("http-default-config", CONFIG_BASE + "http-default.json");
	}
	
	@Test
	public void javaConfigTest() {
		utilities.validateFileAgainstAPI("java-config", CONFIG_BASE + "java.json");
	}
	
	@Test
	public void jdbcConfigTest() {
		utilities.validateFileAgainstAPI("jdbc-config", CONFIG_BASE + "jdbc.json");
	}
	
	@Test
	public void keystoreConfigTest() {
		utilities.validateFileAgainstAPI("keystore-config", CONFIG_BASE + "keystore.json");
	}
	
	@Test
	public void loginConfigTest() {
		utilities.validateFileAgainstAPI("login-config", CONFIG_BASE + "login.json");
	}
	
	@Test
	public void randomValueConfigTest() {
		utilities.validateFileAgainstAPI("random-value-config", CONFIG_BASE + "random-value.json");
	}
	
	@Test
	public void simpleConfigTest() {
		utilities.validateFileAgainstAPI("simple-config", CONFIG_BASE + "simple.json");
	}
	
	@Test
	public void tcpConfigTest() {
		utilities.validateFileAgainstAPI("tcp-config", CONFIG_BASE + "tcp.json");
	}
	
	@Test
	public void userDefinedVariablesTest() {
		utilities.validateFileAgainstAPI("user-defined-variables", CONFIG_BASE + "user-defined-variables.json");
	}
	
	/**
	 * Config tests 
	 * 
	 * 
	 */
}
