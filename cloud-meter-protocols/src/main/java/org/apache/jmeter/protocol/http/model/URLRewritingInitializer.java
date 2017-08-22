package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.protocol.http.modifier.URLRewritingModifier;
import org.apache.jmeter.testelement.TestElement;
import org.cloudmeter.model.AbstractInitializer;

public class URLRewritingInitializer extends AbstractInitializer {

	@Override
	public TestElement initilizeElement() {
		URLRewritingModifier ele = new URLRewritingModifier();
		this.baseElement(ele, "HTTP URL Re-writing Modifier");
		
		ele.setArgumentName(EMPTY_STRING);
		ele.setShouldCache(false);
		ele.setEncode(false);
		ele.setPathExtension(false);
		ele.setPathExtensionNoEquals(false);
		ele.setPathExtensionNoQuestionmark(false);
		
		return ele;
	}

}
