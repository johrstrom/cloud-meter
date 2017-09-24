package org.cloudmeter.testelement;

import org.apache.jmeter.protocol.http.sampler.*;
import org.apache.jmeter.protocol.http.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.apache.jmeter.sampler.model.*;
import org.apache.jmeter.sampler.*;
import org.apache.jmeter.protocol.model.*;
import org.apache.jmeter.protocol.java.sampler.*;
import org.apache.jmeter.protocol.jdbc.sampler.*;
import org.apache.jmeter.protocol.ldap.sampler.*;

@Component
public class SamplerBeans {

	@Bean
	public HTTPSamplerInitializer HTTPSamplerInitializer() {
		return new HTTPSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public HTTPSamplerProxy HTTPSamplerProxy(HTTPSamplerInitializer initer) {
		return (HTTPSamplerProxy) initer.initilizeElement();
	}
	
	@Bean
	public AccessLogSamplerInitializer AccessLogSamplerInitializer() {
		return new AccessLogSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public AccessLogSampler AccessLogSampler(AccessLogSamplerInitializer initer) {
		return (AccessLogSampler) initer.initilizeElement();
	}
	
	@Bean
	public AjpSamplerInitializer AjpSamplerInitializer() {
		return new AjpSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public AjpSampler AjpSampler(AjpSamplerInitializer initer) {
		return (AjpSampler) initer.initilizeElement();
	}
	
	@Bean
	public DebugSamplerInitializer DebugSamplerInitializer() {
		return new DebugSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public DebugSampler DebugSampler(DebugSamplerInitializer initer) {
		return (DebugSampler) initer.initilizeElement();
	}
	
	@Bean
	public JavaSamplerInitializer JavaSamplerInitializer() {
		return new JavaSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public JavaSampler JavaSampler(JavaSamplerInitializer initer) {
		return (JavaSampler) initer.initilizeElement();
	}
	
	@Bean
	public JDBCSamplerInitializer JDBCSamplerInitializer() {
		return new JDBCSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public JDBCSampler JDBCSampler(JDBCSamplerInitializer initer) {
		return (JDBCSampler) initer.initilizeElement();
	}
	
	@Bean
	public LDAPExtSamplerInitializer LDAPExtSamplerInitializer() {
		return new LDAPExtSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public LDAPExtSampler LDAPExtSampler(LDAPExtSamplerInitializer initer) {
		return (LDAPExtSampler) initer.initilizeElement();
	}
	
	@Bean
	public LDAPSamplerInitializer LDAPSamplerInitializer() {
		return new LDAPSamplerInitializer();
	}
	
	@Bean
	@Autowired
	public LDAPSampler LDAPSampler(LDAPSamplerInitializer initer) {
		return (LDAPSampler) initer.initilizeElement();
	}
	
}
