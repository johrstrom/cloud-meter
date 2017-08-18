package org.cloudmeter.testelement;

import org.apache.jmeter.protocol.model.*;
import org.apache.jmeter.protocol.http.control.*;
import org.apache.jmeter.protocol.java.config.JavaConfig;
import org.apache.jmeter.protocol.jdbc.config.DataSourceElement;
import org.apache.jmeter.modifiers.*;
import org.apache.jmeter.modifiers.model.*;
import org.apache.jmeter.config.*;
import org.apache.jmeter.config.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigBeans {

	@Bean
	public AuthManagerInitializer AuthManagerInitializer() {
		return new AuthManagerInitializer();
	}
	
	@Bean
	@Autowired
	public AuthManager AuthManager(AuthManagerInitializer initer) {
		return (AuthManager) initer.initilizeElement();
	}
	
	@Bean
	public CacheManagerInitializer CacheManagerInitializer() {
		return new CacheManagerInitializer();
	}
	
	@Bean
	@Autowired
	public CacheManager CacheManager(CacheManagerInitializer initer) {
		return (CacheManager) initer.initilizeElement();
	}
	
	@Bean
	public CookieManagerInitializer CookieManagerInitializer() {
		return new CookieManagerInitializer();
	}
	
	@Bean
	@Autowired
	public CookieManager CookieManager(CookieManagerInitializer initer) {
		return (CookieManager) initer.initilizeElement();
	}
	
	@Bean
	public CounterConfigInitializer CounterConfigInitializer() {
		return new CounterConfigInitializer();
	}
	
	@Bean
	@Autowired
	public CounterConfig CounterConfig(CounterConfigInitializer initer) {
		return (CounterConfig) initer.initilizeElement();
	}
	
	@Bean
	public CSVDataSetInitializer CSVDataSetInitializer() {
		return new CSVDataSetInitializer();
	}
	
	@Bean
	@Autowired
	public CSVDataSet CSVDataSet(CSVDataSetInitializer initer) {
		return (CSVDataSet) initer.initilizeElement();
	}
	
	@Bean
	public FTPConfigInitializer FTPConfigInitializer() {
		return new FTPConfigInitializer();
	}
	
	@Bean
	@Autowired
	public ConfigTestElement FTPConfig(FTPConfigInitializer initer) {
		return (ConfigTestElement) initer.initilizeElement();
	}
	
	@Bean
	public HeaderManagerInitializer HeaderManagerInitializer() {
		return new HeaderManagerInitializer();
	}
	
	@Bean
	@Autowired
	public HeaderManager HeaderManager(HeaderManagerInitializer initer) {
		return (HeaderManager) initer.initilizeElement();
	}
	
	@Bean
	public HTTPDefaultsInitializer HTTPDefaultsInitializer() {
		return new HTTPDefaultsInitializer();
	}
	
	@Bean
	@Autowired
	public ConfigTestElement HTTPDefaults(HTTPDefaultsInitializer initer) {
		return (ConfigTestElement) initer.initilizeElement();
	}
		
	@Bean
	public JavaConfigInitializer JavaConfigInitializer() {
		return new JavaConfigInitializer();
	}
	
	@Bean
	@Autowired
	public JavaConfig JavaConfig(JavaConfigInitializer initer) {
		return (JavaConfig) initer.initilizeElement();
	}
	
	@Bean
	public JDBCConfigInitializer JDBCConfigInitializer() {
		return new JDBCConfigInitializer();
	}
	
	@Bean
	@Autowired
	public DataSourceElement DataSourceElement(JDBCConfigInitializer initer) {
		return (DataSourceElement) initer.initilizeElement();
	}
	
	@Bean
	public KeystoreConfigInitializer KeystoreConfigInitializer() {
		return new KeystoreConfigInitializer();
	}
	
	@Bean
	@Autowired
	public KeystoreConfig KeystoreConfig(KeystoreConfigInitializer initer) {
		return (KeystoreConfig) initer.initilizeElement();
	}
	
	@Bean
	public LoginConfigInitializer LoginConfigInitializer() {
		return new LoginConfigInitializer();
	}
	
	@Bean
	@Autowired
	public ConfigTestElement LoginConfig(LoginConfigInitializer initer) {
		return (ConfigTestElement) initer.initilizeElement();
	}
	
	@Bean
	public LDAPExtendedConfigInitializer LDAPExtendedConfigInitializer() {
		return new LDAPExtendedConfigInitializer();
	}
	
	@Bean
	@Autowired
	public ConfigTestElement LDAPExtendedConfig(LDAPExtendedConfigInitializer initer) {
		return (ConfigTestElement) initer.initilizeElement();
	}
	
	@Bean
	public LDAPConfigInitializer LDAPConfigInitializer() {
		return new LDAPConfigInitializer();
	}
	
	@Bean
	@Autowired
	public ConfigTestElement LDAPConfig(LDAPConfigInitializer initer) {
		return (ConfigTestElement) initer.initilizeElement();
	}
}


