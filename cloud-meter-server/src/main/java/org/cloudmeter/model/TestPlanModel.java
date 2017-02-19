package org.cloudmeter.model;

import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestPlanModel {
	
	private static final Logger log = LoggerFactory.getLogger(TestPlanModel.class);
	
	
	
	@JsonProperty("hashTree")
	@JsonSerialize(using = TestPlanSerializer.class)
	private HashTree tree;
	
	
	
	
	
//	@JsonProperty("elements")
//	public Map<Object, HashTree> getElements(){
//		return this.testPlanElements;
//	}
	

	public TestPlanModel(){
		this(null);
	}
	
	public TestPlanModel(HashTree tree){
		if(tree == null){
			
			log.debug("creating a new testplan model.");
			
//			tree = new HashTree();
//			tree.add
			
			this.tree = new HashTree(new TestPlan());
//			this.testPlanElements.add(new TestPlan());
			
		}else{
			
			
			
		}
		
	}

}
