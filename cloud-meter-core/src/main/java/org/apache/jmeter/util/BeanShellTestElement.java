/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.jmeter.util;

import java.io.Serializable;

import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.testelement.ThreadListener;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.jorphan.util.JMeterException;
import org.apache.jorphan.util.JOrphanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BeanShellTestElement extends AbstractTestElement
    implements Serializable, Cloneable, ThreadListener, TestStateListener
{
	private static final Logger log = LoggerFactory.getLogger(BeanShellTestElement.class);

    private static final long serialVersionUID = 4;

    //++ For TestBean implementations only
    private static final String BEAN_SHELL_TIMER_PARAMETERS = "BeanShellTestElement.parameters"; 
    private static final String BEAN_SHELL_TIMER_FILENAME = "BeanShellTestElement.filename"; 
    private static final String BEAN_SHELL_TIMER_SCRIPT = "BeanShellTestElement.script"; 
    private static final String BEAN_SHELL_TIMER_RESET =  "BeanShellTestElement.resetInterpreter";
    //-- For TestBean implementations only


    private transient BeanShellInterpreter bshInterpreter = null;

    private transient boolean hasInitFile = false;

    public BeanShellTestElement() {
        super();
        init();
    }

    protected abstract String getInitFileProperty();

    /**
     * Get the interpreter and set up standard script variables.
     * <p>
     * Sets the following script variables:
     * <ul>
     * <li>ctx</li>
     * <li>Label</li>
     * <li>prev</li>
     * <li>props</li>
     * <li>vars</li>
     * </ul>
     * @return the interpreter
     */
    protected BeanShellInterpreter getBeanShellInterpreter() {
        if (isResetInterpreter()) {
            try {
                bshInterpreter.reset();
            } catch (ClassNotFoundException e) {
                log.error("Cannot reset BeanShell: "+e.toString());
            }
        }

        JMeterContext jmctx = JMeterContextService.getContext();
        JMeterVariables vars = jmctx.getVariables();

        try {
            bshInterpreter.set("ctx", jmctx);//$NON-NLS-1$
            bshInterpreter.set("Label", getName()); //$NON-NLS-1$
            bshInterpreter.set("prev", jmctx.getPreviousResult());//$NON-NLS-1$
            bshInterpreter.set("props", JMeterUtils.getJMeterProperties());
            bshInterpreter.set("vars", vars);//$NON-NLS-1$
        } catch (JMeterException e) {
            log.warn("Problem setting one or more BeanShell variables "+e);
        }
        return bshInterpreter;
    }

    private void init() { // WARNING: called from ctor so must not be overridden (i.e. must be private or final)
        this.setParameters(""); // ensure variables are not null
        this.setFilename("");
        this.setScript("");
        try {
            String initFileName = JMeterUtils.getProperty(getInitFileProperty());
            hasInitFile = initFileName != null;
            bshInterpreter = new BeanShellInterpreter(initFileName, log);
        } catch (ClassNotFoundException e) {
            log.error("Cannot find BeanShell: "+e.toString());
        }
    }

    protected Object readResolve() {
        init();
        return this;
    }

    @Override
    public Object clone() {
        BeanShellTestElement o = (BeanShellTestElement) super.clone();
        o.init();
       return o;
    }

    /**
     * Process the file or script from the test element.
     * <p>
     * Sets the following script variables:
     * <ul>
     * <li>FileName</li>
     * <li>Parameters</li>
     * <li>bsh.args</li>
     * </ul>
     * @param bsh the interpreter, not {@code null}
     * @return the result of the script, may be {@code null}
     * 
     * @throws JMeterException when working with the bsh fails
     */
    protected Object processFileOrScript(BeanShellInterpreter bsh) throws JMeterException{
        String fileName = getFilename();
        String params = getParameters();

        bsh.set("FileName", fileName);//$NON-NLS-1$
        // Set params as a single line
        bsh.set("Parameters", params); // $NON-NLS-1$
        // and set as an array
        bsh.set("bsh.args",//$NON-NLS-1$
                JOrphanUtils.split(params, " "));//$NON-NLS-1$

        if (fileName.length() == 0) {
            return bsh.eval(getScript());
        }
        return bsh.source(fileName);
    }

    /**
     * Return the script (TestBean version).
     * Must be overridden for subclasses that don't implement TestBean
     * otherwise the clone() method won't work.
     *
     * @return the script to execute
     */
    public String getScript(){
        return this.getPropertyAsString(BEAN_SHELL_TIMER_SCRIPT);
    }

    /**
     * Set the script (TestBean version).
     * Must be overridden for subclasses that don't implement TestBean
     * otherwise the clone() method won't work.
     *
     * @param s the script to execute (may be blank)
     */
    public void setScript(String s){
        this.setProperty(BEAN_SHELL_TIMER_SCRIPT, s);
    }

    @Override
    public void threadStarted() {
        if (bshInterpreter == null || !hasInitFile) {
            return;
        }
        try {
            bshInterpreter.evalNoLog("threadStarted()"); // $NON-NLS-1$
        } catch (JMeterException ignored) {
            log.debug(getClass().getName() + " : " + ignored.getLocalizedMessage()); // $NON-NLS-1$
        }
    }

    @Override
    public void threadFinished() {
        if (bshInterpreter == null || !hasInitFile) {
            return;
        }
        try {
            bshInterpreter.evalNoLog("threadFinished()"); // $NON-NLS-1$
        } catch (JMeterException ignored) {
            log.debug(getClass().getName() + " : " + ignored.getLocalizedMessage()); // $NON-NLS-1$
        }
    }

    @Override
    public void testEnded() {
        if (bshInterpreter == null || !hasInitFile) {
            return;
        }
        try {
            bshInterpreter.evalNoLog("testEnded()"); // $NON-NLS-1$
        } catch (JMeterException ignored) {
            log.debug(getClass().getName() + " : " + ignored.getLocalizedMessage()); // $NON-NLS-1$
        }
    }

    @Override
    public void testEnded(String host) {
        if (bshInterpreter == null || !hasInitFile) {
            return;
        }
        try {
            bshInterpreter.eval((new StringBuilder("testEnded(\"")) // $NON-NLS-1$
                    .append(host)
                    .append("\")") // $NON-NLS-1$
                    .toString()); // $NON-NLS-1$
        } catch (JMeterException ignored) {
            log.debug(getClass().getName() + " : " + ignored.getLocalizedMessage()); // $NON-NLS-1$
        }
    }

    @Override
    public void testStarted() {
        if (bshInterpreter == null || !hasInitFile) {
            return;
        }
        try {
            bshInterpreter.evalNoLog("testStarted()"); // $NON-NLS-1$
        } catch (JMeterException ignored) {
            log.debug(getClass().getName() + " : " + ignored.getLocalizedMessage()); // $NON-NLS-1$
        }
    }

    @Override
    public void testStarted(String host) {
        if (bshInterpreter == null || !hasInitFile) {
            return;
        }
        try {
            bshInterpreter.eval((new StringBuilder("testStarted(\"")) // $NON-NLS-1$
                    .append(host)
                    .append("\")") // $NON-NLS-1$
                    .toString()); // $NON-NLS-1$
        } catch (JMeterException ignored) {
            log.debug(getClass().getName() + " : " + ignored.getLocalizedMessage()); // $NON-NLS-1$
        }
    }

    // Overridden by non-TestBean implementations to return the property value instead
    public String getParameters() {
        return this.getPropertyAsString(BEAN_SHELL_TIMER_PARAMETERS);
    }

    public void setParameters(String s) {
        this.setProperty(BEAN_SHELL_TIMER_PARAMETERS, s);
    }

    // Overridden by non-TestBean implementations to return the property value instead
    public String getFilename() {
        return this.getPropertyAsString(BEAN_SHELL_TIMER_FILENAME);
    }

    public void setFilename(String s) {
    	this.setProperty(BEAN_SHELL_TIMER_FILENAME, s);
    }

    public boolean isResetInterpreter() {
        return this.getPropertyAsBoolean(BEAN_SHELL_TIMER_RESET);
    }

    public void setResetInterpreter(boolean b) {
        this.setProperty(BEAN_SHELL_TIMER_RESET, b);
    }
}
