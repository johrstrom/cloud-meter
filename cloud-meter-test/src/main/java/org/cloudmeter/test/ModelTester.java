package org.cloudmeter.test;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.ScriptingTestElement;
import org.junit.Assert;

public class ModelTester {

	/**
	 * Test all the basic fields that a TestElement should have when 
	 * created by {@link org.cloudmeter.AbstractInitializer}
	 * 
	 * @param expectedName
	 * @param ele
	 */
	public static void testBasicFields(String expectedName, TestElement ele) {
		Assert.assertTrue(ele != null);
		Assert.assertTrue(ele.isEnabled());
		Assert.assertSame(expectedName, ele.getName());
	}
	
	
	/**
	 * Test all the base fields that a {@link org.apache.jmeter.util.ScriptingTestElement}
	 * should have when created by a {@link org.cloudmeter.AbstractInitializer}
	 * 
	 * @param expectedLanguage
	 * @param ele
	 */
	public static void testBasicScriptFields(String expectedLanguage, ScriptingTestElement ele) {
		Assert.assertSame("", ele.getFilename());
		Assert.assertSame("", ele.getParameters());
		Assert.assertSame("", ele.getScript());
		Assert.assertSame(expectedLanguage, ele.getScriptLanguage());
	}
	
}
