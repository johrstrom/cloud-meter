package org.cloudmeter.controller;

import javax.ws.rs.QueryParam;

import org.cloudmeter.model.TestPlan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1/testplan")
public class TestPlanController {

	
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json" )
    public TestPlan getTestPlan(@QueryParam(value = "") String name){
    
    	if(name == null || name.isEmpty()){
    		return new TestPlan();
    	}else{
    		return null;
    	}
    	
    }
    
    
}
