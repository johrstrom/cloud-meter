package org.cloudmeter.model;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jorphan.collections.HashTree;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestElementModel {
	
	private AbstractTestElement testelement;
		
	private String type;
	
	@JsonSerialize(using = HashTreeSerializer.class)
	private HashTree hashTree;
	
	public AbstractTestElement getElement() {
		return testelement;
	}
	
	public void setElement(AbstractTestElement testelement) {
		this.testelement = testelement;
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
