package org.cloudmeter.utils;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.cloudmeter.model.response.RunResultModel;
import org.springframework.http.HttpStatus;


@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class CloudMeterEngineException extends Throwable {

	
	private static final long serialVersionUID = -487897966531746668L;
	
	private RunResultModel model = new RunResultModel();
	
	public CloudMeterEngineException(){
		this("failure");
	}
	
	public CloudMeterEngineException(String message){
		this.model.setMessage(message);
		this.model.setTestRunId("null");
	}

}
