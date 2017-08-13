package org.cloudmeter.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.QueryParam;

import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.cloudmeter.engine.CloudMeterEngine;
import org.cloudmeter.model.TestElementModel;
import org.cloudmeter.model.TestPlanModel;
import org.cloudmeter.model.request.RunRequest;
import org.cloudmeter.model.response.RunResultModel;
import org.cloudmeter.service.CloudMeterService;
import org.cloudmeter.server.util.CloudMeterEngineException;
import org.cloudmeter.server.util.CloudMeterStartup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/v1")
@CrossOrigin
public class V1Controller {

	private static final Logger log = LoggerFactory.getLogger(V1Controller.class);
	
	private final Map<String, CloudMeterEngine> cache;
	
	@Autowired
	private CloudMeterService service;
	
	public V1Controller() {
		this.cache = new ConcurrentHashMap<String, CloudMeterEngine>();
	}
	
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
    	    		
			@SuppressWarnings("deprecation")
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
 
    
    @RequestMapping(value = "/testplan", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody TestPlanModel getTestPlan(@QueryParam(value = "name") String name){
    
    	if(name == null || name.isEmpty()){
    		return new TestPlanModel();
    	}else{
    		File testplan = new File("./testplans/" + name);
			try {
				HashTree tree = SaveService.loadTree(testplan);
				return new TestPlanModel(tree);
				
			} catch (IOException e) {
				log.error("Couldn't read file for tesplan {}. Message is {}", testplan, e.getMessage());
			}
    		
    		return new TestPlanModel();
    	}
    	
    }
    
    @RequestMapping(value = "/testelement", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody TestElementModel newTestElement(
    		@QueryParam(value = "name") String name,
    		@QueryParam(value = "type") String type){
    	
    	return this.service.newTestElement(name, type);
    	
    }
    
    


}
