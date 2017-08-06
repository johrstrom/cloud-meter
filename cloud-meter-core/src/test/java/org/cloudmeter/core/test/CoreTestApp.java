package org.cloudmeter.core.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.cloudmeter", "org.apache.jmeter"})
@EnableAutoConfiguration()
public class CoreTestApp {
	
    public static void main(String[] args) {
        SpringApplication.run(CoreTestApp.class, args);        
    }
    
}

