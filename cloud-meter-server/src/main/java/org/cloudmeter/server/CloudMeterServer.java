package org.cloudmeter.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudMeterServer {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String doHome(){
		return "redirect:/html/base/base.html";
	}
	
//	@RequestMapping()
//	public String doTestPlan(){
//		return "sfda";
//	}
}
