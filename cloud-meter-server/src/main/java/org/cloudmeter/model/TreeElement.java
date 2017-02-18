package org.cloudmeter.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TreeElement {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("enabled")
	private boolean enabled;
	
	@JsonProperty("testclass")
	private String testclass;
	
	@JsonProperty("testname")
	private String testname;
	
	@JsonProperty("properties")
	private Map<String, TreeModelElementProperty> properties;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the testname
	 */
	public String getTestname() {
		return testname;
	}

	/**
	 * @param testname the testname to set
	 */
	public void setTestname(String testname) {
		this.testname = testname;
	}

	/**
	 * @return the testclass
	 */
	public String getTestclass() {
		return testclass;
	}

	/**
	 * @param testclass the testclass to set
	 */
	public void setTestclass(String testclass) {
		this.testclass = testclass;
	}
	
}
