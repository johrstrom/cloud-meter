package org.cloudmeter.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudMeterServer {

	@RequestMapping("/home")
	public String doHome(){
		return "Hello there!";
	}
	
}
