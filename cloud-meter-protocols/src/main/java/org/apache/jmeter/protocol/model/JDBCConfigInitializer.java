package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.jdbc.config.DataSourceElement;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class JDBCConfigInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		DataSourceElement ele = new DataSourceElement();
		this.baseElement(ele, "JDBC Connection Configuration");
		
		ele.setAutocommit(true);
		ele.setCheckQuery("Select 1");
		ele.setConnectionAge("5000");
		ele.setDataSource(EMPTY_STRING);
		ele.setDbUrl(EMPTY_STRING);
		ele.setDriver(EMPTY_STRING);
		ele.setKeepAlive(true);
		ele.setPassword(EMPTY_STRING);
		ele.setPoolMax("10");
		ele.setTimeout("10000");
		ele.setTransactionIsolation("DEFAULT");
		ele.setTrimInterval("60000");
		ele.setUsername(EMPTY_STRING);

		return ele;
	}

}
