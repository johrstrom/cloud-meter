package org.cloudmeter.model.request;

import org.springframework.web.multipart.MultipartFile;

public class RunRequest {

	private MultipartFile testPlan;

	public MultipartFile getTestPlan() {
		return testPlan;
	}

	public void setTestPlan(MultipartFile testPlan) {
		this.testPlan = testPlan;
	}
	
}
