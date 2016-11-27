package org.cloudmeter.controller;

import java.io.IOException;

import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.save.SaveService.XStreamWrapper;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.engine.StandardCloudMeterEngine;
import org.cloudmeter.model.request.RunRequest;
import org.cloudmeter.model.response.RunResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;

@Controller
@RequestMapping("/testplan")
public class RunController {

	private static final Logger log = LoggerFactory.getLogger(RunController.class);
	
	private static final XStream JMXSAVER = new XStreamWrapper(new PureJavaReflectionProvider());
	
    @RequestMapping(value = "/run", method = RequestMethod.POST, produces = "application/json" , 
    		consumes = { "application/x-www-form-urlencoded", "multipart/form-data" })
    public @ResponseBody RunResultModel runTestPlan(@ModelAttribute RunRequest request) {
    	
    	RunResultModel res = new RunResultModel();
    	
    	if(request == null){
    		log.info("request is null. returning empty response");
    		res.setMessage("request is null");
    		return res;
    	}else if(request.getTestPlan() == null){
    		log.info("request testplan is null. returning empty response");
    		res.setMessage("testplan is null");
    		return res;
    	}
    	

    	try {
        	ScriptWrapper wrapper = (ScriptWrapper) JMXSAVER.fromXML(request.getTestPlan().getInputStream());
        	HashTree test = wrapper.testPlan;
        	
        	StandardCloudMeterEngine e = new StandardCloudMeterEngine();
        	e.configure(test);
        	
			e.runTest();
		} catch (JMeterEngineException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	return null;
    }
    
    class ScriptWrapper {
        // Used by ScriptWrapperConverter
        String version = "";

        HashTree testPlan;
    }
    

}
