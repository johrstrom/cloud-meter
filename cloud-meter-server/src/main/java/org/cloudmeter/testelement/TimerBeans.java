package org.cloudmeter.testelement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.apache.jmeter.timers.model.*;
import org.apache.jmeter.timers.*;

@Component
public class TimerBeans {

	@Bean
	public BeanShellTimerInitializer BeanShellTimerInitializer() {
		return new BeanShellTimerInitializer();
	}
	
	@Bean
	@Autowired
	public BeanShellTimer BeanShellTimer(BeanShellTimerInitializer initer) {
		return (BeanShellTimer) initer.initilizeElement();
	}
	
	@Bean
	public ConstantThroughputTimerInitializer ConstantThroughputTimerInitializer() {
		return new ConstantThroughputTimerInitializer();
	}
	
	@Bean
	@Autowired
	public ConstantThroughputTimer ConstantThroughputTimer(ConstantThroughputTimerInitializer initer) {
		return (ConstantThroughputTimer) initer.initilizeElement();
	}
	
	@Bean
	public ConstantTimerInitializer ConstantTimerInitializer() {
		return new ConstantTimerInitializer();
	}
	
	@Bean
	@Autowired
	public ConstantTimer ConstantTimer(ConstantTimerInitializer initer) {
		return (ConstantTimer) initer.initilizeElement();
	}
	
	@Bean
	public GaussianRandomTimerInitializer GaussianRandomTimerInitializer() {
		return new GaussianRandomTimerInitializer();
	}
	
	@Bean
	@Autowired
	public GaussianRandomTimer GaussianRandomTimer(GaussianRandomTimerInitializer initer) {
		return (GaussianRandomTimer) initer.initilizeElement();
	}
}
