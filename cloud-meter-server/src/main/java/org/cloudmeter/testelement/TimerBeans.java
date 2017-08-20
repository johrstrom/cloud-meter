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
	
	@Bean
	public JSR223TimerInitializer JSR223TimerInitializer() {
		return new JSR223TimerInitializer();
	}
	
	@Bean
	@Autowired
	public JSR223Timer JSR223Timer(JSR223TimerInitializer initer) {
		return (JSR223Timer) initer.initilizeElement();
	}
	
	@Bean
	public PoissonRandomTimerInitializer PoissonRandomTimerInitializer() {
		return new PoissonRandomTimerInitializer();
	}
	
	@Bean
	@Autowired
	public PoissonRandomTimer PoissonRandomTimer(PoissonRandomTimerInitializer initer) {
		return (PoissonRandomTimer) initer.initilizeElement();
	}
	
	@Bean
	public SyncTimerInitializer SyncTimerInitializer() {
		return new SyncTimerInitializer();
	}
	
	@Bean
	@Autowired
	public SyncTimer SyncTimer(SyncTimerInitializer initer) {
		return (SyncTimer) initer.initilizeElement();
	}
	
	@Bean
	public UniformRandomTimerInitializer UniformRandomTimerInitializer() {
		return new UniformRandomTimerInitializer();
	}
	
	@Bean
	@Autowired
	public UniformRandomTimer UniformRandomTimer(UniformRandomTimerInitializer initer) {
		return (UniformRandomTimer) initer.initilizeElement();
	}
}
