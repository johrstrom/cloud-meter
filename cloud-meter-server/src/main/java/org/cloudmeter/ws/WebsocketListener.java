package org.cloudmeter.ws;

import org.apache.jmeter.engine.util.NoThreadClone;
import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleListener;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestStateListener;

public class WebsocketListener extends AbstractTestElement
	implements  SampleListener, TestStateListener, NoThreadClone {

	private static final long serialVersionUID = 2684575238667435355L;
//	WSClient 
	
	public WebsocketListener(){
		
	}

	@Override
	public void testStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testStarted(String host) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testEnded(String host) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sampleOccurred(SampleEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sampleStarted(SampleEvent e) {}		//do nothing

	@Override
	public void sampleStopped(SampleEvent e) {}		//do nothing

	
}
