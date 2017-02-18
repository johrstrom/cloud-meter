package org.cloudmeter.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.jorphan.collections.HashTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPlanModel {
	
	@JsonProperty("elements")
	List<TreeElement> testPlanElements;
	private static final Logger log = LoggerFactory.getLogger(TestPlanModel.class);
	
	@JsonProperty("elements")
	public List<TreeElement> getElements(){
		return this.testPlanElements;
	}

	public TestPlanModel(){
		this(null);
	}
	
	public TestPlanModel(HashTree tree){
		if(tree == null){
			
			log.debug("creating a new testplan model.");
			
			this.testPlanElements = new ArrayList<TreeElement>();
			this.testPlanElements.add(new TreeElement());
			
		}else{
			HashTreeModelConverter converter = new HashTreeModelConverter();
			
			
		}
		
	}

}
