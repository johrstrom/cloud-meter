package org.apache.jmeter.protocol.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.ldap.sampler.LDAPExtSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class LDAPExtendedConfigInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		ConfigTestElement ele = new ConfigTestElement();
		this.baseElement(ele, "LDAP Extended Request Defaults");
		
		ele.setProperty(LDAPExtSampler.ATTRIBS, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.COMPAREDN, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.COMPAREFILT, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.CONNTO, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.COUNTLIM, 0l);
		ele.setProperty(LDAPExtSampler.DEREF, false);
		ele.setProperty(LDAPExtSampler.MODDDN, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.NEWDN, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.PARSEFLAG, false);
		ele.setProperty(LDAPExtSampler.PORT, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.RETOBJ, false);
		ele.setProperty(LDAPExtSampler.ROOTDN, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.SCOPE, 2);
		ele.setProperty(LDAPExtSampler.SECURE, false);
		ele.setProperty(LDAPExtSampler.SERVERNAME, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.TIMELIM, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.USERDN, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.USERPW, EMPTY_STRING);
		
		return ele;
	}

}
