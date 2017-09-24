package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.ldap.sampler.LDAPExtSampler;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class LDAPExtSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		LDAPExtSampler ele = new LDAPExtSampler();
		this.baseElement(ele, "LDAP Extended Request");
		
		ele.setAttrs(EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.COMPAREDN, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.COMPAREFILT, EMPTY_STRING);
		ele.setConnTimeOut(EMPTY_STRING);
		ele.setDeref(false);
		ele.setProperty(LDAPExtSampler.MODDDN, EMPTY_STRING);
		ele.setProperty(LDAPExtSampler.NEWDN, EMPTY_STRING);
		ele.setParseFlag(false);
		ele.setPort(EMPTY_STRING);
		ele.setRetobj(false);
		ele.setRootdn(EMPTY_STRING);
		ele.setScope(2);
		ele.setSecure(false);
		ele.setServername(EMPTY_STRING);
		ele.setTimelim(0);
		ele.setUserDN(EMPTY_STRING);
		ele.setUserPw(EMPTY_STRING);
		ele.setCountlim(0);
		
		return ele;
	}

}
