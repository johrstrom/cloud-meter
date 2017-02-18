package org.cloudmeter.model;

import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.HashTreeTraverser;

public class HashTreeModelConverter implements HashTreeTraverser {

	TestPlanModel plan = new TestPlanModel();
	
	public TestPlanModel getTestPlanModel(){
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
