package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.mail.sampler.MailReaderSampler;
import org.apache.jmeter.protocol.smtp.sampler.SecuritySettings;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class MailReaderSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		MailReaderSampler ele = new MailReaderSampler();
		this.baseElement(ele, "Mail Reader Sampler");
		
		ele.setProperty(SecuritySettings.ENFORCE_STARTTLS, false);
		ele.setProperty(SecuritySettings.SSL_TRUST_ALL_CERTS, false);
		ele.setProperty(SecuritySettings.TRUSTSTORE_TO_USE, EMPTY_STRING);
		ele.setProperty(SecuritySettings.USE_LOCAL_TRUSTSTORE, false);
		ele.setProperty(SecuritySettings.USE_SSL, false);
		ele.setProperty(SecuritySettings.USE_STARTTLS, false);
		ele.setDeleteMessages(false);
		ele.setFolder("INBOX");
		ele.setServer(EMPTY_STRING);
		ele.setServerType("pop3");
		ele.setNumMessages(-1);
		ele.setPassword(EMPTY_STRING);
		ele.setUserName(EMPTY_STRING);
		
		return ele;
	}

}
