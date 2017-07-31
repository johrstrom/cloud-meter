package org.cloudmeter.model;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.collections.HashTree;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestElementModel {
	
	private TestElement testelement;
		
	private String type;
	
	@JsonSerialize(using = HashTreeSerializer.class)
	private HashTree hashTree;
	
	public TestElement getElement() {
		return testelement;
	}
	
	public void setElement(TestElement testelement) {
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
