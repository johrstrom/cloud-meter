package org.cloudmeter.server.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServerUtils {
	
	@Bean
	public Map<String, String> testElementNameLookup() {
    	HashMap<String, String>  map = new HashMap<>();
    	
    	map.put("thread-group", "ThreadGroup");

    	map.putAll(this.controllerElements());
    	map.putAll(this.configElements());
    	map.putAll(this.timerElements());
    	map.putAll(this.preProcessorElements());
    	map.putAll(this.samplerElements());
    	
    	return map;
    }
	
	
	private  Map<String, String> controllerElements() {
		HashMap<String, String>  map = new HashMap<>();
		
    	map.put("critical-section-controller", "CriticalSectionController");
    	map.put("foreach-controller", "ForeachController");
    	map.put("if-controller", "IfController");
    	map.put("include-controller", "IncludeController");
    	map.put("loop-controller", "LoopController");
//    	map.put("module-controller", ModuleController.class);
    	map.put("once-only-controller", "OnceOnlyController");
    	map.put("random-controller", "RandomController");
    	map.put("random-order-controller", "RandomOrderController");
//    	map.put("simple-controller", SimpleController.class);
    	map.put("switch-controller", "SwitchController");
    	map.put("throughput-controller", "ThroughputController");
    	map.put("transaction-controller", "TransactionController");
    	map.put("while-controller", "WhileController");
    	
		return map;
	}
	
	private  Map<String, String> configElements() {
		HashMap<String, String>  map = new HashMap<>();
		
		map.put("http-auth-config", "AuthManager");
		map.put("http-cache-config", "CacheManager");
		map.put("http-cookie-config", "CookieManager");
		map.put("counter", "CounterConfig");
		map.put("csv-dataset", "CSVDataSet");
		map.put("ftp-config", "FTPConfig");
		map.put("http-header-config", "HeaderManager");
		map.put("http-defaults-config", "HTTPDefaults");
		map.put("java-config", "JavaConfig");
		map.put("jdbc-config", "DataSourceElement");
		map.put("keystore-config", "KeystoreConfig");
		map.put("ldap-extended-config", "LDAPExtendedConfig");
		map.put("ldap-config", "LDAPConfig");
		map.put("login-config", "LoginConfig");
		map.put("random-variable-config", "RandomVariableConfig");
		map.put("simple-config", "SimpleConfig");
		map.put("tcp-config", "TCPConfig");
		map.put("user-defined-variables", "UserDefinedVariables");
		
		return map;
	}
	
	private  Map<String, String> timerElements() {
		HashMap<String, String>  map = new HashMap<>();
		
		map.put("bean-shell-timer", "BeanShellTimer");
		map.put("constant-throughput-timer", "ConstantThroughputTimer");
		map.put("constant-timer", "ConstantTimer");
		map.put("gaussian-random-timer", "GaussianRandomTimer");
		map.put("jsr223-timer", "JSR223Timer");
		map.put("poisson-random-timer", "PoissonRandomTimer");
		map.put("sync-timer", "SyncTimer");
		map.put("uniform-random-timer", "UniformRandomTimer");
				
		return map;
	}
	
	private  Map<String, String> preProcessorElements() {
		HashMap<String, String>  map = new HashMap<>();
		
		map.put("bean-shell-pre-processor", "BeanShellPreProcessor");
		map.put("html-link-pre-processor", "HTMLLinkPreProcessor");
		map.put("jdbc-pre-processor", "JDBCPreProcessor");
		map.put("jsr223-pre-processor", "JSR223PreProcessor");
		map.put("regex-user-parameters-pre-processor", "RegExUserParameters");
		map.put("sample-timeout-pre-processor", "SampleTimeout");
		map.put("url-rewrite-pre-processor", "URLRewritingModifier");
		map.put("user-parameters-pre-processor", "UserParameters");
				
		return map;
	}
	
	private  Map<String, String> samplerElements() {
		HashMap<String, String>  map = new HashMap<>();
    	
    	map.put("access-log-sampler","AccessLogSampler");
    	map.put("ajp-sampler", "AjpSampler");
    	map.put("debug-sampler", "DebugSampler");
    	map.put("http-sampler", "HTTPSamplerProxy");
    	map.put("java-sampler", "JavaSampler");
    	map.put("jdbc-sampler", "JDBCSampler.json");
    	map.put("ldap-extended-sampler", "LDAPSampler.json");
    	map.put("ldap-sampler", "LDAP.json");
    	map.put("mail-reader-sampler", "MailReader.json");
   		map.put("os-process-sampler", "OSProcessSampler.json");
   		map.put("smtp-sampler", "SMTP.json");
   		map.put("tcp-sampler", "TCPSampler.json");
   		map.put("test-action-sampler", "TestActionSampler.json");
    	
		return map;
	}

}
