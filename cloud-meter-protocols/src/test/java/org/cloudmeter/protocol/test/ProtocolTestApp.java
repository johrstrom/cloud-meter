package org.cloudmeter.protocol.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@SpringBootApplication
@ComponentScan({"org.cloudmeter", "org.apache.jmeter"})
@EnableAutoConfiguration()
public class ProtocolTestApp {
	
    public static void main(String[] args) {
        SpringApplication.run(ProtocolTestApp.class, args);        
    }
    
    @Controller
    public class ProtocolTestController {
    	
    }
    
    @Service
    public class ProtocolTestService {
    	
    }
}
