package org.cloudmeter.testelement;

import org.apache.jmeter.modifiers.model.*;
import org.apache.jmeter.protocol.http.modifier.AnchorModifier;
import org.apache.jmeter.modifiers.*;
import org.apache.jmeter.protocol.model.*;
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
}
