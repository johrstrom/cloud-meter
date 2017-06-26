package org.cloudmeter.model;

import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestPlanModel {
	
	private static final Logger log = LoggerFactory.getLogger(TestPlanModel.class);
	
	
	
	@JsonProperty("TestPlan")
	@JsonSerialize(using = HashTreeSerializer.class)
	private HashTree tree;
	

	public TestPlanModel(){
		this(null);
	}
	
	public TestPlanModel(HashTree tree){
		log.debug("creating a new testplan model.");
		
		if(tree == null){	
			this.tree = new HashTree(new TestPlan("Test Plan"));
		}else{
			this.tree = tree;
		}
		
	}

}
