package org.cloudmeter.server.util;

import java.io.InputStream;

import org.apache.jmeter.util.JMeterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class CloudMeterStartup implements ApplicationListener<ContextStartedEvent> {

	private static final Logger log = LoggerFactory.getLogger(CloudMeterStartup.class);
	
	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {
		try{
			
			log.info("Starting CloudMeterStartup from source: " + arg0.getSource().toString());
			
			InputStream is = CloudMeterStartup.class.getClassLoader().getResourceAsStream("jmeter.properties");
			
			JMeterUtils.loadJmeterProperties(is);
			
			log.info("Property load complete. Cloud-Meter properties initialized.");
			
		}catch(Exception e){
			log.error("exception while loading properties: " + e.getClass().toString() + "/" + e.getMessage());
		}
		
	}

}

