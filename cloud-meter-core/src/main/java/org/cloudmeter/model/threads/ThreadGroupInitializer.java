package org.cloudmeter.model.threads;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.BooleanProperty;
import org.apache.jmeter.testelement.property.LongProperty;
import org.apache.jmeter.threads.AbstractThreadGroup;
import org.apache.jmeter.threads.ThreadGroup;
import org.cloudmeter.model.ModelInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ThreadGroupInitializer implements ModelInitializer {

	
	private static final Logger log = LoggerFactory.getLogger(ThreadGroupInitializer.class);
	
	@Override
	public void initilizeElement(TestElement ele) {
		
        if (ele instanceof AbstractThreadGroup) {
            ((AbstractThreadGroup) ele).setSamplerController(createController());
        }
        
        ele.setName("Thread Group");
        ele.setProperty(AbstractThreadGroup.NUM_THREADS, "1");
        ele.setProperty(ThreadGroup.RAMP_TIME, "1");
        ele.setProperty(new LongProperty(ThreadGroup.START_TIME, System.currentTimeMillis()));
        ele.setProperty(new LongProperty(ThreadGroup.END_TIME, System.currentTimeMillis()));
//        if (showDelayedStart) {
//            tg.setProperty(ThreadGroup.DELAYED_START, delayedStart.isSelected(), false);
//        }
        ele.setProperty(new BooleanProperty(ThreadGroup.SCHEDULER, true));
        ele.setProperty(ThreadGroup.DURATION, "1");
        ele.setProperty(ThreadGroup.DELAY, "1");
        
	}
	
	
	
	private LoopController createController() {
		LoopController lc = new LoopController();
		
		lc.setLoops(LoopController.INFINITE_LOOP_COUNT);
		
		return lc;
	}

}
