package org.cloudmeter.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TreeModelElementProperty {
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("value")
	private Object value;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	protected void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		
		if (value instanceof String){
			this.setType(String.class.getName());
			
		}else if (value instanceof Boolean){
			this.setType(Boolean.class.getName());
			
		}else if (value instanceof Long){
			this.setType(Long.class.getName());	
			
		}else if(value instanceof Collection){
			this.setType(Collection.class.getName());	
		}else{
			throw new IllegalArgumentException("properties can only be java.lang.String, "
					+ "java.lang.Boolean or java.lang.Long");
		}
		
		this.value = value;
	}
		
		
		
	
	
	

	
	
}
