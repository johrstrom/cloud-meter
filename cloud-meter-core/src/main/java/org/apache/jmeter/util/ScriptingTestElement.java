/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.apache.jmeter.util;

import org.apache.jmeter.testelement.AbstractTestElement;

/**
 * Common parent class for the {@link BSFTestElement} and {@link JSR223TestElement} scripting test elements.
 * These also share the {@link ScriptingBeanInfoSupport} class for configuration.
 */
public abstract class ScriptingTestElement extends AbstractTestElement {

    private static final long serialVersionUID = 281L;

    //++ For TestBean implementations only
    protected static final String SCRIPTING_ELEMENT_PARAMETERS = "ScriptingTestElement.parameters"; 

    protected static final String SCRIPTING_ELEMENT_FILENAME = "ScriptingTestElement.filename"; 

    protected static final String SCRIPTING_ELEMENT_SCRIPT = "ScriptingTestElement.script";

    protected static final String SCRIPTING_ELEMENT_LANG = "ScriptingTestElement.scriptLanguage";
   

    public ScriptingTestElement() {
        super();
    }

    /**
     * Return the script (TestBean version).
     * Must be overridden for subclasses that don't implement TestBean
     * otherwise the clone() method won't work.
     *
     * @return the script to execute
     */
    public String getScript(){
        return this.getPropertyAsString(SCRIPTING_ELEMENT_SCRIPT);
    }

    /**
     * Set the script (TestBean version).
     * Must be overridden for subclasses that don't implement TestBean
     * otherwise the clone() method won't work.
     *
     * @param s the script to execute (may be blank)
     */
    public void setScript(String s){
       this.setProperty(SCRIPTING_ELEMENT_SCRIPT, s);
    }

    public String getParameters() {
        return this.getPropertyAsString(SCRIPTING_ELEMENT_PARAMETERS);
    }

    public void setParameters(String s) {
    	this.setProperty(SCRIPTING_ELEMENT_PARAMETERS, s);
    }

    public String getFilename() {
        return this.getPropertyAsString(SCRIPTING_ELEMENT_FILENAME);
    }

    public void setFilename(String s) {
        this.setProperty(SCRIPTING_ELEMENT_FILENAME, s);
    }
    
    public String getScriptLanguage() {
        return this.getPropertyAsString(SCRIPTING_ELEMENT_LANG);
    }

    public void setScriptLanguage(String s) {
        this.setProperty(SCRIPTING_ELEMENT_LANG, s);
    }


}
