package org.apache.jmeter.modifiers.model;

import org.apache.jmeter.modifiers.UserParameters;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.cloudmeter.model.AbstractInitializer;

public class UserParametersInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		UserParameters ele = new UserParameters();
		this.baseElement(ele, "User Parameters");
		
		ele.setProperty(this.createNewCollectionProperty(UserParameters.NAMES));
		ele.setProperty(this.createNewCollectionProperty(UserParameters.THREAD_VALUES));
		ele.setProperty(UserParameters.PER_ITERATION, false);
		
		
		return ele;
	}
	
	private CollectionProperty createNewCollectionProperty(String name) {
		CollectionProperty prop = new CollectionProperty();
		prop.setName(name);
		
		return prop;
	}

}
