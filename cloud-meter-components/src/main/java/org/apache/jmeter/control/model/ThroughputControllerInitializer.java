package org.apache.jmeter.control.model;

import org.apache.jmeter.control.ThroughputController;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class ThroughputControllerInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		ThroughputController ele = new ThroughputController();
		this.baseElement(ele, "Throughput Controller");
		
		ele.setMaxThroughput(1);
		ele.setPerThread(false);
		ele.setPercentThroughput(1.0f);
		ele.setStyle(1);
		
		return ele;
	}

}
