package org.apache.jmeter.protocol.model;

import org.apache.jmeter.protocol.smtp.sampler.SecuritySettings;
import org.apache.jmeter.protocol.smtp.sampler.SmtpSampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.cloudmeter.model.AbstractInitializer;

public class SmtpSamplerInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		SmtpSampler ele = new SmtpSampler();
		this.baseElement(ele, "SMTP Sampler");
		
		ele.setProperty(SecuritySettings.ENFORCE_STARTTLS, false);
		ele.setProperty(SecuritySettings.SSL_TRUST_ALL_CERTS, false);
		ele.setProperty(SecuritySettings.TRUSTSTORE_TO_USE, EMPTY_STRING);
		ele.setProperty(SecuritySettings.USE_LOCAL_TRUSTSTORE, false);
		ele.setProperty(SecuritySettings.USE_SSL, false);
		ele.setProperty(SecuritySettings.USE_STARTTLS, false);
		
		ele.setProperty(SmtpSampler.ATTACH_FILE, EMPTY_STRING);
		ele.setProperty(SmtpSampler.EML_MESSAGE_TO_SEND, EMPTY_STRING);
		ele.setProperty(SmtpSampler.ENABLE_DEBUG, false);
		ele.setProperty(SmtpSampler.INCLUDE_TIMESTAMP, false);
		ele.setProperty(SmtpSampler.MAIL_FROM, EMPTY_STRING);
		ele.setProperty(SmtpSampler.MESSAGE, EMPTY_STRING);
		ele.setProperty(SmtpSampler.MESSAGE_SIZE_STATS, false);
		ele.setProperty(SmtpSampler.PASSWORD, EMPTY_STRING);
		ele.setProperty(SmtpSampler.PLAIN_BODY, false);
		ele.setProperty(SmtpSampler.RECEIVER_BCC, EMPTY_STRING);
		ele.setProperty(SmtpSampler.RECEIVER_CC, EMPTY_STRING);
		ele.setProperty(SmtpSampler.RECEIVER_TO, EMPTY_STRING);
		ele.setProperty(SmtpSampler.MAIL_REPLYTO, EMPTY_STRING);
		ele.setProperty(SmtpSampler.SERVER, EMPTY_STRING);
		ele.setProperty(SmtpSampler.SERVER_PORT, EMPTY_STRING);
		ele.setProperty(SmtpSampler.SUBJECT, EMPTY_STRING);
		ele.setProperty(SmtpSampler.SUPPRESS_SUBJECT, false);
		ele.setProperty(SmtpSampler.USE_AUTH, false);
		ele.setProperty(SmtpSampler.USE_EML, false);
		ele.setProperty(SmtpSampler.USERNAME, EMPTY_STRING);
		
//		ele.setProperty(SmtpSampler, EMPTY_STRING);
		
		CollectionProperty headers = new CollectionProperty();
		headers.setName(SmtpSampler.HEADER_FIELDS);
		ele.setProperty(headers);
		
		return ele;
	}

}
