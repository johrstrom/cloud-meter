package org.cloudmeter.server.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.control.*;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.threads.ThreadGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServerUtils {
	
	@Bean
	public Map<String, Class<? extends AbstractTestElement>> testElementNameLookup() {
    	HashMap<String, Class<? extends AbstractTestElement>>  map = new HashMap<>();
    	
    	map.put("thread-group", ThreadGroup.class);
    	map.put("http-sampler", HTTPSamplerProxy.class);

    	map.putAll(this.controllerElements());
    	
    	return map;
    }
	
	
	private  Map<String, Class<? extends AbstractTestElement>> controllerElements() {
		HashMap<String, Class<? extends AbstractTestElement>>  map = new HashMap<>();
		
    	map.put("critical-section-controller", CriticalSectionController.class);
    	map.put("foreach-controller", ForeachController.class);
    	map.put("if-controller", IfController.class);
    	map.put("include-controller", IncludeController.class);
 	
    	map.put("loop-controller", LoopController.class);
//    	map.put("module-controller", ModuleController.class);
    	map.put("once-only-controller", OnceOnlyController.class);
    	map.put("random-controller", RandomController.class);
    	map.put("random-order-controller", RandomOrderController.class);
//    	map.put("simple-controller", SimpleController.class);
    	map.put("throughput-controller", ThroughputController.class);
    	map.put("transaction-controller", TransactionController.class);
    	map.put("while-controller", WhileController.class);
    	
		return map;
	}

}
