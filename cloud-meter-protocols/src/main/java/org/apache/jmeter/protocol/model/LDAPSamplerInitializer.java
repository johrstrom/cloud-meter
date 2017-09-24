package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.config.model.ArgumentsInitializer;
import org.apache.jmeter.protocol.ldap.sampler.LDAPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class LDAPSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		LDAPSampler ele = new LDAPSampler();
		
		Arguments args = (Arguments) new ArgumentsInitializer().initilizeElement();
		ele.setArguments(args);
		
		ele.setProperty(ConfigTestElement.USERNAME, EMPTY_STRING);
		ele.setProperty(ConfigTestElement.PASSWORD, EMPTY_STRING);
		ele.setProperty("base_entry_dn", EMPTY_STRING);
		ele.setProperty("port", EMPTY_STRING);
		ele.setProperty("rootdn", EMPTY_STRING);
		ele.setProperty("servername", EMPTY_STRING);
		ele.setProperty("test", "add");
		ele.setProperty("user_defined", false);
		
		this.baseElement(ele, "LDAP Request");		
		return ele;
	}
	
	

}
