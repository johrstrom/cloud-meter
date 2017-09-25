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

/**
 * 
 * Validate the GET /api/v1/testelement API for all test elements. 
 * This class tests only happy path for the api. Given correct
 * parameters, validate the response against a file in 
 * src/test/resources/testelements. 
 * 
 * @author Jeff Ohrstrom
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CloudMeterApp.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NewElementTest {
	
	private static final String FILE_BASE = "target/test-classes/testelements";
	private static final String SAMPLER_BASE = FILE_BASE + "/samplers/";
	private static final String CONTROLLER_BASE = FILE_BASE + "/controllers/";
	private static final String CONFIG_BASE = FILE_BASE + "/config/";
	private static final String TIMER_BASE = FILE_BASE + "/timers/";
	private static final String PRE_PROCCESSOR_BASE = FILE_BASE + "/pre-processors/";
	
	@Autowired
	private TestUtilities utilities;

	@LocalServerPort
	int port;
	
	
	@Before 
	public void setup() {
		utilities.setPort(port);
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
		utilities.validateFileAgainstAPI("ftp-config", CONFIG_BASE + "ftp.json");
	}
	
	@Test
	public void httpHeaderConfigTest() {
		utilities.validateFileAgainstAPI("http-header-config", CONFIG_BASE + "header.json");
	}
	
	@Test
	public void httpDefaultConfigTest() {
		utilities.validateFileAgainstAPI("http-defaults-config", CONFIG_BASE + "http-defaults.json");
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
	public void ldapExtendedConfigTest() {
		utilities.validateFileAgainstAPI("ldap-extended-config", CONFIG_BASE + "ldap-extended.json");
	}
	
	@Test
	public void ldapConfigTest() {
		utilities.validateFileAgainstAPI("ldap-config", CONFIG_BASE + "ldap.json");
	}
	
	@Test
	public void loginConfigTest() {
		utilities.validateFileAgainstAPI("login-config", CONFIG_BASE + "login.json");
	}
	
	@Test
	public void randomValueConfigTest() {
		utilities.validateFileAgainstAPI("random-variable-config", CONFIG_BASE + "random-variable.json");
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
	 * Config tests end
	 * 
	 * Timer tests start 
	 */
	
	@Test
	public void beanShellTimerTest() {
		utilities.validateFileAgainstAPI("bean-shell-timer", TIMER_BASE + "bean-shell.json");
	}
	
	@Test
	public void constantThroughputTimerTest() {
		utilities.validateFileAgainstAPI("constant-throughput-timer", TIMER_BASE + "constant-throughput.json");
	}
	
	@Test
	public void constantTimerTest() {
		utilities.validateFileAgainstAPI("constant-timer", TIMER_BASE + "constant.json");
	}
	
	@Test
	public void gaussianRandomTimerTest() {
		utilities.validateFileAgainstAPI("gaussian-random-timer", TIMER_BASE + "gaussian-random.json");
	}
	
	@Test
	public void jsr223TimerTest() {
		utilities.validateFileAgainstAPI("jsr223-timer", TIMER_BASE + "jsr223.json");
	}
	
	@Test
	public void poissonRandomTimerTest() {
		utilities.validateFileAgainstAPI("poisson-random-timer", TIMER_BASE + "poisson-random.json");
	}
	
	@Test
	public void syncTimerTest() {
		utilities.validateFileAgainstAPI("sync-timer", TIMER_BASE + "synchronization.json");
	}
	
	@Test
	public void uniformRandomTimerTest() {
		utilities.validateFileAgainstAPI("uniform-random-timer", TIMER_BASE + "uniform-random.json");
	}
	
	/**
	 * Timer tests end
	 * 
	 * Pre Processors start
	 */
	
	@Test
	public void beanShellPreProcessorTest() {
		utilities.validateFileAgainstAPI("bean-shell-pre-processor", PRE_PROCCESSOR_BASE + "bean-shell.json");
	}
	
	@Test
	public void htmlLinkPreProcessorTest() {
		utilities.validateFileAgainstAPI("html-link-pre-processor", PRE_PROCCESSOR_BASE + "html-link.json");
	}
	
	@Test
	public void jdbcPreProcessorTest() {
		utilities.validateFileAgainstAPI("jdbc-pre-processor", PRE_PROCCESSOR_BASE + "jdbc.json");
	}
	
	@Test
	public void jsr223PreProcessorTest() {
		utilities.validateFileAgainstAPI("jsr223-pre-processor", PRE_PROCCESSOR_BASE + "jsr223.json");
	}
	
	@Test
	public void regexUserParamsPreProcessorTest() {
		utilities.validateFileAgainstAPI("regex-user-parameters-pre-processor", PRE_PROCCESSOR_BASE + "regex-user-parameters.json");
	}
	
	@Test
	public void sampleTimeoutPreProcessorTest() {
		utilities.validateFileAgainstAPI("sample-timeout-pre-processor", PRE_PROCCESSOR_BASE + "sample-timeout.json");
	}
	
	@Test
	public void urlreWritePreProcessorTest() {
		utilities.validateFileAgainstAPI("url-rewrite-pre-processor", PRE_PROCCESSOR_BASE + "url-rewrite.json");
	}
	
	@Test
	public void userParamsPreProcessorTest() {
		utilities.validateFileAgainstAPI("user-parameters-pre-processor", PRE_PROCCESSOR_BASE + "user-parameters.json");
	}
	
	/**
	 * Pre Processors end
	 * 
	 * Sampler begin
	 */
	
	@Test
	public void accessLogSamplerTest() {
		utilities.validateFileAgainstAPI("access-log-sampler", SAMPLER_BASE + "access-log.json");
	}
	
	@Test
	public void ajpSamplerTest() {
		utilities.validateFileAgainstAPI("ajp-sampler", SAMPLER_BASE + "ajp.json");
	}
	
	@Test
	public void debugSamplerTest() {
		utilities.validateFileAgainstAPI("debug-sampler", SAMPLER_BASE + "debug.json");
	}
	
	@Test
	public void httpSamplerTest() {
		utilities.validateFileAgainstAPI("http-sampler", SAMPLER_BASE + "http.json");
	}
	
	@Test
	public void javaSamplerTest() {
		utilities.validateFileAgainstAPI("java-sampler", SAMPLER_BASE + "java.json");
	}
	
	@Test
	public void jdbcSamplerTest() {
		utilities.validateFileAgainstAPI("jdbc-sampler", SAMPLER_BASE + "jdbc.json");
	}
	
	@Test
	public void ldapExtendedSamplerTest() {
		utilities.validateFileAgainstAPI("ldap-extended-sampler", SAMPLER_BASE + "ldap-extended.json");
	}
	
	@Test
	public void ldapSamplerTest() {
		utilities.validateFileAgainstAPI("ldap-sampler", SAMPLER_BASE + "ldap.json");
	}
	
	@Test
	public void mailReaderSamplerTest() {
		utilities.validateFileAgainstAPI("mail-reader-sampler", SAMPLER_BASE + "mail-reader.json");
	}
	
	@Test
	public void osProcessSamplerTest() {
		utilities.validateFileAgainstAPI("os-process-sampler", SAMPLER_BASE + "os-process.json");
	}
	
	@Test
	public void smtpSamplerTest() {
		utilities.validateFileAgainstAPI("smtp-sampler", SAMPLER_BASE + "smtp.json");
	}
	
	@Test
	public void tcpSamplerTest() {
		utilities.validateFileAgainstAPI("tcp-sampler", SAMPLER_BASE + "tcp.json");
	}
	
	@Test
	public void testActionTest() {
		utilities.validateFileAgainstAPI("test-action", SAMPLER_BASE + "test-action.json");
	}
	
}
