package org.cloudmeter.server;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudMeterServer {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String doHome(Model model){
		return "home";
	}
	
//	@RequestMapping()
//	public String doTestPlan(){
//		return "sfda";
//	}
}
