package org.cloudmeter.model;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jorphan.collections.HashTree;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestElementModel {
	
//	@JsonProperty("testelement")
//	@JsonSerialize(using = TestElementSerializer.class)
	private AbstractTestElement element;
		
	private String type;
	
	@JsonSerialize(using = HashTreeSerializer.class)
	private HashTree hashTree;
	
	public AbstractTestElement getElement() {
		return element;
	}
	
	public void setElement(AbstractTestElement element) {
		this.element = element;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HashTree getHashTree() {
		return hashTree;
	}

	public void setHashTree(HashTree hashTree) {
		this.hashTree = hashTree;
	}

}
