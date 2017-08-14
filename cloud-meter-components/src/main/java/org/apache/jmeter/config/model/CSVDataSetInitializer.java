package org.apache.jmeter.config.model;

import org.apache.jmeter.config.CSVDataSet;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitialzer;

public class CSVDataSetInitializer extends AbstractInitialzer {

	@Override
	public TestElement initilizeElement() {
		CSVDataSet ele = new CSVDataSet();
		this.baseElement(ele, "CSV Data Set Config");
		
		ele.setDelimiter(",");
		ele.setFileEncoding(EMPTY_STRING);
		ele.setFilename(EMPTY_STRING);
		ele.setQuotedData(false);
		ele.setRecycle(true);
		ele.setShareMode("shareMode.all");
		ele.setStopThread(false);
		ele.setVariableNames(EMPTY_STRING);
		
		return ele;
	}

}
