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
    	map.put("http-sampler", "HTTPSamplerProxy");

    	map.putAll(this.controllerElements());
    	map.putAll(this.configElements());
    	
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
		map.put("tcp-config", "ConfigTestElement");
		map.put("user-defined-config", "Arguments");
		
		return map;
	}

}
