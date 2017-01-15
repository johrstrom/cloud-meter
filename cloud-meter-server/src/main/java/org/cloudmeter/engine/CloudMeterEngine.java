package org.cloudmeter.engine;

import java.util.Properties;
import java.util.UUID;

import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jorphan.collections.HashTree;

public class CloudMeterEngine implements JMeterEngine, Runnable {

	StandardJMeterEngine engine = new StandardJMeterEngine();
	String id = UUID.randomUUID().toString();
	
	public CloudMeterEngine(){
		this.engine = new StandardJMeterEngine();
	}
	
	public String getId(){
		return this.id;
	}
	
	@Override
	public void run() {
		this.engine.run();
	}

	@Override
	public void configure(HashTree testPlan) {
		this.engine.configure(testPlan);
	}

	@Override
	public void runTest() throws JMeterEngineException {
		this.engine.runTest();
	}

	@Override
	public void stopTest(boolean now) {
		this.engine.stopTest();
	}

	@Override
	public void reset() {
		this.engine.reset();
	}

	@Override
	public void setProperties(Properties p) {
		this.engine.setProperties(p);
	}

	@Override
	public void exit() {
		this.engine.exit();
	}

	@Override
	public boolean isActive() {
		return this.engine.isActive();
	}

}
