package org.cloudmeter.model;

import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.HashTreeTraverser;

public class HashTreeModelConverter implements HashTreeTraverser {

	TestPlan plan = new TestPlan();
	
	public TestPlan getTestPlanModel(){
		return this.plan;
	}
	
	@Override
	public void addNode(Object node, HashTree subTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subtractNode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processPath() {
		// TODO Auto-generated method stub
		
	}

	
}
