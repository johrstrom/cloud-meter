package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class LDAPExtendedConfigInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConfigTestElement ele = new ConfigTestElement();
		this.baseElement(ele, "LDAP Extended Request Defaults");
		
		ele.setProperty("attributes", EMPTY_STRING);
		ele.setProperty("comparedn", EMPTY_STRING);
		ele.setProperty("comparefilt", EMPTY_STRING);
		ele.setProperty("connection_timeout", EMPTY_STRING);
		ele.setProperty("countlimit", EMPTY_STRING);
		ele.setProperty("deref_aliases", false);
		ele.setProperty("modddn", EMPTY_STRING);
		ele.setProperty("newdn", EMPTY_STRING);
		ele.setProperty("parseflag", false);
		ele.setProperty("port", EMPTY_STRING);
		ele.setProperty("return_object", false);
		ele.setProperty("rootdn", EMPTY_STRING);
		ele.setProperty("scope", 2);
		ele.setProperty("secure", false);
		ele.setProperty("servername", EMPTY_STRING);
		ele.setProperty("timelimit", EMPTY_STRING);
		ele.setProperty("user_dn", EMPTY_STRING);
		ele.setProperty("user_pw", EMPTY_STRING);
		
		return ele;
	}

}
