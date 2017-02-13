package org.cloudmeter.model;

import java.util.Map;

public class TreeElement {
	private String name;
	private boolean enabled;
	private String testclass;
	private String testname;
	
	private Map<String, String> elementProps;
	private Map<String, Boolean> boolProps;
	private Map<String, String> stringProps;
	private Map<String, Long> longProps;
	
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

	/**
	 * @return the elementProps
	 */
	public Map<String, String> getElementProps() {
		return elementProps;
	}

	/**
	 * @param elementProps the elementProps to set
	 */
	public void setElementProps(Map<String, String> elementProps) {
		this.elementProps = elementProps;
	}

	/**
	 * @return the stringProps
	 */
	public Map<String, String> getStringProps() {
		return stringProps;
	}

	/**
	 * @param stringProps the stringProps to set
	 */
	public void setStringProps(Map<String, String> stringProps) {
		this.stringProps = stringProps;
	}

	/**
	 * @return the boolProps
	 */
	public Map<String, Boolean> getBoolProps() {
		return boolProps;
	}

	/**
	 * @param boolProps the boolProps to set
	 */
	public void setBoolProps(Map<String, Boolean> boolProps) {
		this.boolProps = boolProps;
	}

	/**
	 * @return the longProps
	 */
	public Map<String, Long> getLongProps() {
		return longProps;
	}

	/**
	 * @param longProps the longProps to set
	 */
	public void setLongProps(Map<String, Long> longProps) {
		this.longProps = longProps;
	}
	
	
}
