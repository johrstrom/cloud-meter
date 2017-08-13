package org.cloudmeter.testelement;

import org.apache.jmeter.control.*;
import org.apache.jmeter.control.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ControllerBeans {

	@Bean
	public CriticalSectionControllerInitializer CriticalSectionControllerInitializer() {
		return new CriticalSectionControllerInitializer();
	}
	
	@Bean
	@Autowired
	public CriticalSectionController CriticalSectionController(CriticalSectionControllerInitializer initer) {
		return (CriticalSectionController) initer.initilizeElement();
	}
	
	@Bean
	public ForeachControllerInitializer ForeachControllerInitializer() {
		return new ForeachControllerInitializer();
	}
	
	@Bean
	@Autowired
	public ForeachController ForeachController(ForeachControllerInitializer initer) {
		return (ForeachController) initer.initilizeElement();
	}
	
	@Bean
	public IfControllerInitializer IfControllerInitializer() {
		return new IfControllerInitializer();
	}
	
	@Bean
	@Autowired
	public IfController IfController(IfControllerInitializer initer) {
		return (IfController) initer.initilizeElement();
	}
	
	@Bean
	public IncludeControllerInitializer IncludeControllerInitializer() {
		return new IncludeControllerInitializer();
	}
	
	@Bean
	@Autowired
	public IncludeController IncludeController(IncludeControllerInitializer initer) {
		return (IncludeController) initer.initilizeElement();
	}
	
	@Bean
	public LoopControllerInitializer LoopControllerInitializer() {
		return new LoopControllerInitializer();
	}
	
	@Bean
	@Autowired
	public LoopController LoopController(LoopControllerInitializer initer) {
		return (LoopController) initer.initilizeElement();
	}
	
}
