package org.cloudmeter.testelement;

import org.apache.jmeter.modifiers.model.*;
import org.apache.jmeter.protocol.http.modifier.AnchorModifier;
import org.apache.jmeter.protocol.http.modifier.*;
import org.apache.jmeter.modifiers.*;
import org.apache.jmeter.protocol.model.*;
import org.apache.jmeter.protocol.http.model.*;
import org.apache.jmeter.protocol.jdbc.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProcessorBeans {

	@Bean
	public BeanShellPreProcessorInitializer BeanShellPreProcessorInitializer() {
		return new BeanShellPreProcessorInitializer();
	}
	
	@Bean
	@Autowired
	public BeanShellPreProcessor BeanShellPreProcessor(BeanShellPreProcessorInitializer initer) {
		return (BeanShellPreProcessor) initer.initilizeElement();
	}
	
	@Bean
	public HTMLLinkPreProcessorInitializer HTMLLinkPreProcessorInitializer() {
		return new HTMLLinkPreProcessorInitializer();
	}
	
	@Bean
	@Autowired
	public AnchorModifier HTMLLinkPreProcessor(HTMLLinkPreProcessorInitializer initer) {
		return (AnchorModifier) initer.initilizeElement();
	}
	
	@Bean
	public JDBCPreProcessorInitializer JDBCPreProcessorInitializer() {
		return new JDBCPreProcessorInitializer();
	}
	
	@Bean
	@Autowired
	public JDBCPreProcessor JDBCPreProcessor(JDBCPreProcessorInitializer initer) {
		return (JDBCPreProcessor) initer.initilizeElement();
	}
	
	@Bean
	public JSR223PreProcessorInitializer JSR223PreProcessorInitializer() {
		return new JSR223PreProcessorInitializer();
	}
	
	@Bean
	@Autowired
	public JSR223PreProcessor JSR223PreProcessor(JSR223PreProcessorInitializer initer) {
		return (JSR223PreProcessor) initer.initilizeElement();
	}
	
	@Bean
	public RegExUserParametersInitializer RegExUserParametersInitializer() {
		return new RegExUserParametersInitializer();
	}
	
	@Bean
	@Autowired
	public RegExUserParameters RegExUserParameters(RegExUserParametersInitializer initer) {
		return (RegExUserParameters) initer.initilizeElement();
	}
	
	@Bean
	public SampleTimeoutInitializer SampleTimeoutInitializer() {
		return new SampleTimeoutInitializer();
	}
	
	@Bean
	@Autowired
	public SampleTimeout SampleTimeout(SampleTimeoutInitializer initer) {
		return (SampleTimeout) initer.initilizeElement();
	}
	
	@Bean
	public URLRewritingInitializer URLRewritingInitializer() {
		return new URLRewritingInitializer();
	}
	
	@Bean
	@Autowired
	public URLRewritingModifier URLRewritingModifier(URLRewritingInitializer initer) {
		return (URLRewritingModifier) initer.initilizeElement();
	}

	@Bean
	public UserParametersInitializer UserParametersInitializer() {
		return new UserParametersInitializer();
	}
	
	@Bean
	@Autowired
	public UserParameters UserParameters(UserParametersInitializer initer) {
		return (UserParameters) initer.initilizeElement();
	}
}
