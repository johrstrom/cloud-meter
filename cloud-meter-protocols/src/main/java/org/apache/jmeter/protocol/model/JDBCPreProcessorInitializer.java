package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.jdbc.processor.JDBCPreProcessor;
import org.apache.jmeter.protocol.jdbc.processor.JDBCProccessorInitializer;
import org.apache.jmeter.testelement.TestElement;

public class JDBCPreProcessorInitializer extends JDBCProccessorInitializer {

	@Override
	public TestElement initilizeElement() {
		JDBCPreProcessor ele = new JDBCPreProcessor();
		this.baseElement(ele, "JDBC PreProcessor");
		this.initJDBCElement(ele);
		
		return ele;
	}

}
