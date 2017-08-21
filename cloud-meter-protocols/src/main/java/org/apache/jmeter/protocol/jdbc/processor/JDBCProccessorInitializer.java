package org.apache.jmeter.protocol.jdbc.processor;

import org.apache.jmeter.protocol.jdbc.AbstractJDBCTestElement;
import org.cloudmeter.model.AbstractInitializer;

public abstract class JDBCProccessorInitializer extends AbstractInitializer {

	public void initJDBCElement(AbstractJDBCTestElement ele) {
		ele.setQueryType(AbstractJDBCTestElement.SELECT);
		ele.setResultSetHandler(AbstractJDBCTestElement.RS_STORE_AS_STRING);
		ele.setQueryTimeout(0);
		
		ele.setDataSource(EMPTY_STRING);
		ele.setQuery(EMPTY_STRING);
		ele.setQueryArguments(EMPTY_STRING);
		ele.setQueryArgumentsTypes(EMPTY_STRING);
		ele.setVariableNames(EMPTY_STRING);
		ele.setResultVariable(EMPTY_STRING);
	}

}
