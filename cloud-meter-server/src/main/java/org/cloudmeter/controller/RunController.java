package org.cloudmeter.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.engine.CloudMeterEngine;
import org.cloudmeter.messaging.SampleResultMessage;
import org.cloudmeter.model.request.RunRequest;
import org.cloudmeter.model.response.RunResultModel;
import org.cloudmeter.utils.CloudMeterEngineException;
import org.cloudmeter.utils.CloudMeterStartup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/v1/test")
public class RunController {

	private static final Logger log = LoggerFactory.getLogger(RunController.class);
	
	Map<String, CloudMeterEngine> cache = new ConcurrentHashMap();
	
	static {
		try{
			InputStream is = CloudMeterStartup.class.getClassLoader().getResourceAsStream("jmeter.properties");
			JMeterUtils.loadJmeterProperties(is);
			JMeterUtils.initLocale();
			log.info("Property load complete. Cloud-Meter properties initialized.");
			
		}catch(Exception e){
			log.error("exception while loading properties: " + e.getClass().toString() + "/" + e.getMessage());
		}
	}
	
    @MessageMapping("/sample-result")
    @SendTo("/topic/testresults/{testId}")
	public SampleResult temp(SampleResult result, @DestinationVariable String testId){
		return result;
	}
	
    @RequestMapping(value = "/run", method = RequestMethod.POST, produces = "application/json" , 
    		consumes = { "application/x-www-form-urlencoded", "multipart/form-data" })
    public @ResponseBody RunResultModel runTestPlan(@ModelAttribute RunRequest request) 
    		throws CloudMeterEngineException {
    	
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
    		
			HashTree test = SaveService.loadTree(request.getTestPlan().getInputStream());
			
        	CloudMeterEngine e = new CloudMeterEngine();
        	e.configure(test);
        	
			e.runTest();
			this.cache.put(e.getId(), e);
			
			res.setTestRunId(e.getId());
			res.setMessage("success");
			return res;
			
		} catch (JMeterEngineException | IOException e1) {
			
			throw new CloudMeterEngineException();
		} 
    	
    }
 
    

}
