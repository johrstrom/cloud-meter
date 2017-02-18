package org.cloudmeter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.AbstractSubscribableChannel;
//import org.springframework.messaging.support.ChannelInterceptor;

import org.cloudmeter.CloudMeterApp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CloudMeterApp.class)
@WebAppConfiguration
public class TopicTest {

//	@Autowired
//	AbstractSubscribableChannel chan; 
	
	@Test
	public void abc(){
//		chan.addInterceptor(new ChannelInterceptor() i);
		
	}
}
