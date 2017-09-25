package org.apache.jmeter.protocol.http.model;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.http.control.*;
import org.apache.jmeter.protocol.http.modifier.AnchorModifier;
import org.apache.jmeter.protocol.http.modifier.RegExUserParameters;
import org.apache.jmeter.protocol.http.modifier.URLRewritingModifier;
import org.apache.jmeter.protocol.http.sampler.*;
import org.apache.jmeter.protocol.http.util.accesslog.TCLogParser;
import org.cloudmeter.test.ModelTester;
import org.junit.Assert;
import org.junit.Test;

public class HTTPModelTest {
	
	@Test
	public void httpSamplerTest() {
		HTTPSamplerInitializer initer = new HTTPSamplerInitializer();
		HTTPSamplerProxy ele = (HTTPSamplerProxy) initer.initilizeElement();
		
		ModelTester.testBasicFields("HTTP Request", ele);
	}
	
	@Test
	public void httpCacheTest() {
		CacheManagerInitializer initer = new CacheManagerInitializer();
		CacheManager ele = (CacheManager) initer.initilizeElement();
			
		ModelTester.testBasicFields("HTTP Cache Manager", ele);
		
		Assert.assertTrue(ele.getMaxSize() == 5000);
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertFalse(ele.getUseExpires());
		
	}

	
	@Test
	public void httpCookieTest() {
		CookieManagerInitializer initer = new CookieManagerInitializer();
		CookieManager ele = (CookieManager) initer.initilizeElement();

		ModelTester.testBasicFields("HTTP Cookie Manager", ele);
		
		Assert.assertFalse(ele.getClearEachIteration());
		Assert.assertTrue("org.apache.jmeter.protocol.http.control.HC4CookieHandler".equals(ele.getImplementation()));
		Assert.assertTrue("standard".equals(ele.getPolicy()));
		Assert.assertTrue(ele.getCookieCount() == 0);
	}
	
	@Test
	public void headerManagerTest() {
		HeaderManagerInitializer initer = new HeaderManagerInitializer();
		HeaderManager ele = (HeaderManager) initer.initilizeElement();
		
		ModelTester.testBasicFields("HTTP Header Manager", ele);
	}
	
	@Test
	public void httpDefaultsTest() {
		HTTPDefaultsInitializer initer = new HTTPDefaultsInitializer();
		ConfigTestElement ele = (ConfigTestElement) initer.initilizeElement();
		
		ModelTester.testBasicFields("HTTP Request Defaults", ele);
		
		Assert.assertTrue("6".equals(ele.getPropertyAsString(HTTPSampler.CONCURRENT_POOL)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.CONNECT_TIMEOUT)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.CONTENT_ENCODING)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.DOMAIN)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.PATH)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.PORT)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.PROTOCOL)));
		Assert.assertTrue("".equals(ele.getPropertyAsString(HTTPSampler.RESPONSE_TIMEOUT)));
		Assert.assertTrue(ele.getProperty(HTTPSampler.ARGUMENTS) != null);		
		
	}
	
	@Test
	public void htmlLinkPreProcessorTest() {
		HTMLLinkPreProcessorInitializer initer = new HTMLLinkPreProcessorInitializer();
		AnchorModifier ele = (AnchorModifier) initer.initilizeElement();
		
		ModelTester.testBasicFields("HTML Link Parser", ele);
	}
	
	@Test
	public void RegExUserParametersTest() {
		RegExUserParametersInitializer initer = new RegExUserParametersInitializer();
		RegExUserParameters ele = (RegExUserParameters) initer.initilizeElement();
		
		ModelTester.testBasicFields("RegEx User Parameters", ele);
		
		Assert.assertSame("", ele.getRegExParamValuesGrNr());
		Assert.assertSame("", ele.getRegExRefName());
		Assert.assertSame("", ele.getRegParamNamesGrNr());
	}
	
	@Test
	public void urlRewritingTest() {
		URLRewritingInitializer initer = new URLRewritingInitializer();
		URLRewritingModifier ele = (URLRewritingModifier) initer.initilizeElement();
		
		ModelTester.testBasicFields("HTTP URL Re-writing Modifier", ele);
		
		Assert.assertSame("", ele.getArgumentName());
		Assert.assertFalse(ele.shouldCache());
		Assert.assertFalse(ele.encode());
		Assert.assertFalse(ele.isPathExtension());
		Assert.assertFalse(ele.isPathExtensionNoEquals());
		Assert.assertFalse(ele.isPathExtensionNoQuestionmark());
	}
	
	@Test
	public void accessLogSamplerTest() {
		AccessLogSamplerInitializer initer = new AccessLogSamplerInitializer();
		AccessLogSampler ele = (AccessLogSampler) initer.initilizeElement();
		
		ModelTester.testBasicFields("Access Log Sampler", ele);
		
		Assert.assertSame("", ele.getDomain());
		Assert.assertFalse(ele.isImageParser());
		Assert.assertFalse(ele.isImageParsing());
		Assert.assertSame("", ele.getLogFile());
		Assert.assertSame(TCLogParser.class.getName(), ele.getParserClassName());
		Assert.assertTrue(80 == ele.getPort());
		Assert.assertSame("", ele.getFilterClassName());
	}
	
	public void ajpSamplerTest() {
		AjpSamplerInitializer initer = new AjpSamplerInitializer();
		AjpSampler ele = (AjpSampler) initer.initilizeElement();
		
		ModelTester.testBasicFields("AJP/1.3 Sampler", ele);
		
		Assert.assertTrue(ele.getFollowRedirects());
		Assert.assertSame(HTTPSamplerBase.GET, ele.getMethod());
		Assert.assertFalse(ele.getDoMultipartPost());
		Assert.assertSame("", ele.getContentEncoding());
		Assert.assertSame("", ele.getDomain());
		Assert.assertSame("", ele.getEmbeddedUrlRE());
		Assert.assertSame("", ele.getPath());
		Assert.assertFalse(ele.getAutoRedirects());
		Assert.assertTrue(ele.getFollowRedirects());
		Assert.assertTrue(ele.getUseKeepAlive());
		Assert.assertTrue(80 == ele.getPort());
		Assert.assertSame("", ele.getProtocol());
	}
	
}
