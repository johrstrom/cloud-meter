package org.cloudmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.cloudmeter")
@EnableAutoConfiguration
public class CloudMeterApp {
	
    public static void main(String[] args) {
        SpringApplication.run(CloudMeterApp.class, args);        
    }
    
}
