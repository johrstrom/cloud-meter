package org.cloudmeter.utils;

import org.cloudmeter.model.threads.ThreadGroupInitializer;
import org.springframework.context.annotation.Bean;

public class InitializingBeans {
	
	
	@Bean
	public ThreadGroupInitializer threadGroupInitializer() {
		return new ThreadGroupInitializer();
	}
	
//	@Bean
//	public 

}
