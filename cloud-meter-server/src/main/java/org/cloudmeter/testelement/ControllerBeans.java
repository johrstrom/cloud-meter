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
	
	@Bean
	public OnceOnlyControllerInitializer OnceOnlyControllerInitializer() {
		return new OnceOnlyControllerInitializer();
	}
	
	@Bean
	@Autowired
	public OnceOnlyController OnceOnlyController(OnceOnlyControllerInitializer initer) {
		return (OnceOnlyController) initer.initilizeElement();
	}
	
	@Bean
	public RandomControllerInitializer RandomControllerInitializer() {
		return new RandomControllerInitializer();
	}
	
	@Bean
	@Autowired
	public RandomController RandomController(RandomControllerInitializer initer) {
		return (RandomController) initer.initilizeElement();
	}
	
	@Bean
	public RandomOrderControllerInitializer RandomOrderControllerInitializer() {
		return new RandomOrderControllerInitializer();
	}
	
	@Bean
	@Autowired
	public RandomOrderController RandomOrderController(RandomOrderControllerInitializer initer) {
		return (RandomOrderController) initer.initilizeElement();
	}
	
	@Bean
	public SwitchControllerInitializer SwitchControllerInitializer() {
		return new SwitchControllerInitializer();
	}
	
	@Bean
	@Autowired
	public SwitchController SwitchController(SwitchControllerInitializer initer) {
		return (SwitchController) initer.initilizeElement();
	}
	
	@Bean
	public ThroughputControllerInitializer ThroughputControllerInitializer() {
		return new ThroughputControllerInitializer();
	}
	
	@Bean
	@Autowired
	public ThroughputController ThroughputController(ThroughputControllerInitializer initer) {
		return (ThroughputController) initer.initilizeElement();
	}
}
