package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.jdbc.AbstractJDBCTestElement;
import org.apache.jmeter.protocol.jdbc.sampler.JDBCSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class JDBCSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		JDBCSampler ele = new JDBCSampler();
		this.baseElement(ele, "JDBC Request");
		
		ele.setDataSource(EMPTY_STRING);
		ele.setQuery(EMPTY_STRING);
		ele.setQueryArguments(EMPTY_STRING);
		ele.setQueryArgumentsTypes(EMPTY_STRING);
		ele.setQueryTimeout(0);
		ele.setQueryType(AbstractJDBCTestElement.SELECT);
		ele.setResultSetHandler(AbstractJDBCTestElement.RS_STORE_AS_STRING);
		ele.setResultVariable(EMPTY_STRING);
		ele.setVariableNames(EMPTY_STRING);
		
		return ele;
	}

}
