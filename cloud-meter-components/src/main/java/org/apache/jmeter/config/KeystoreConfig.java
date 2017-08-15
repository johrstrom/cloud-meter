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

package org.apache.jmeter.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.util.SSLManager;
import org.apache.jorphan.util.JMeterStopTestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configure Keystore
 */
public class KeystoreConfig extends ConfigTestElement implements TestBean, TestStateListener {

    private static final long serialVersionUID = -5781402012242794890L;
	private static final Logger log = LoggerFactory.getLogger(KeystoreConfig.class);

    private static final String KEY_STORE_START_INDEX = "https.keyStoreStartIndex"; 
    private static final String KEY_STORE_END_INDEX   = "https.keyStoreEndIndex"; 
    private static final String KEY_STORE_PRELOAD   = "https.keyStorePreload"; 
    private static final String KEY_STORE_CLIENT_CERT_ALIAS_VAR_NAME = "https.keyStoreClientCertAliasVarName";    
    
    public KeystoreConfig() {
        super();
    }

    @Override
    public void testEnded() {
        testEnded(null);
    }

    @Override
    public void testEnded(String host) {
        log.info("Destroying Keystore");         
        SSLManager.getInstance().destroyKeystore();
    }

    @Override
    public void testStarted() {
        testStarted(null);
    }

    @Override
    public void testStarted(String host) {
        String reuseSSLContext = JMeterUtils.getProperty("https.use.cached.ssl.context");
        if(StringUtils.isEmpty(reuseSSLContext)||"true".equals(reuseSSLContext)) {
            log.warn("https.use.cached.ssl.context property must be set to false to ensure Multiple Certificates are used");
        }
        int startIndexAsInt = JMeterUtils.getPropDefault(KEY_STORE_START_INDEX, 0);
        int endIndexAsInt = JMeterUtils.getPropDefault(KEY_STORE_END_INDEX, 0);
        
        if(!StringUtils.isEmpty(this.getStartIndex())) {
            try {
                startIndexAsInt = Integer.parseInt(this.getStartIndex());
            } catch(NumberFormatException e) {
                log.warn("Failed parsing startIndex :'"+this.getStartIndex()+"', "
                		+ "will default to:'"+startIndexAsInt+"', error message:"+ e.getMessage(), e);
            }
        } 
        
        if(!StringUtils.isEmpty(this.getEndIndex())) {
            try {
                endIndexAsInt = Integer.parseInt(this.getEndIndex());
            } catch(NumberFormatException e) {
                log.warn("Failed parsing endIndex :'"+this.getEndIndex()+"', "
                		+ "will default to:'"+endIndexAsInt+"', error message:"+ e.getMessage(), e);
            }
        } 
        if(startIndexAsInt>endIndexAsInt) {
            throw new JMeterStopTestException("Keystore Config error : Alias start index must be lower than Alias end index");
        }
        log.info("Configuring Keystore with (preload:"+this.isPreload()+", startIndex:"+
                startIndexAsInt+", endIndex:"+endIndexAsInt+
                ", clientCertAliasVarName:'" + this.getClientCertAliasVarName() +"')");

        SSLManager.getInstance().configureKeystore(this.isPreload(),
                startIndexAsInt, 
                endIndexAsInt,
                this.getClientCertAliasVarName());
    }

    /**
     * @return the endIndex
     */
    public String getEndIndex() {
        return this.getPropertyAsString(KEY_STORE_END_INDEX);
    }

    /**
     * @param endIndex the endIndex to set
     */
    public void setEndIndex(String endIndex) {
        this.setProperty(KEY_STORE_END_INDEX, endIndex);
    }

    /**
     * @return the startIndex
     */
    public String getStartIndex() {
        return this.getPropertyAsString(KEY_STORE_START_INDEX);
    }

    /**
     * @param startIndex the startIndex to set
     */
    public void setStartIndex(String startIndex) {
        this.setProperty(KEY_STORE_START_INDEX, startIndex);
    }

    /**
     * @return the preload
     */
    public boolean isPreload() {
        return this.getPropertyAsBoolean(KEY_STORE_PRELOAD);
    }

    /**
     * @param preload the preload to set
     */
    public void setPreload(boolean preload) {
    	this.setProperty(KEY_STORE_PRELOAD, preload);
    }

    /**
     * @return the clientCertAliasVarName
     */
    public String getClientCertAliasVarName() {
        return this.getPropertyAsString(KEY_STORE_CLIENT_CERT_ALIAS_VAR_NAME);
    }

    /**
     * @param clientCertAliasVarName the clientCertAliasVarName to set
     */
    public void setClientCertAliasVarName(String clientCertAliasVarName) {
        this.setProperty(KEY_STORE_CLIENT_CERT_ALIAS_VAR_NAME, clientCertAliasVarName);
    }
}
