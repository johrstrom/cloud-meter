package org.cloudmeter.testelement;

import org.apache.jmeter.protocol.model.*;
import org.apache.jmeter.protocol.http.control.*;
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
}
