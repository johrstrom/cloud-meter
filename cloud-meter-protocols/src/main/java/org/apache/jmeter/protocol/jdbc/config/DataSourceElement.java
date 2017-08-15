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
 */
package org.apache.jmeter.protocol.jdbc.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.jmeter.config.ConfigElement;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.TestBeanHelper;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.slf4j.LoggerFactory;
import org.apache.jorphan.util.JOrphanUtils;
import org.slf4j.Logger;

public class DataSourceElement extends AbstractTestElement
    implements ConfigElement, TestStateListener, TestBean {
	private static final Logger log = LoggerFactory.getLogger(DataSourceElement.class);

    private static final long serialVersionUID = 234L;
    
    public static final String DATA_SOURCE = "DataSourceElement.dataSource";
    public static final String DRIVER = "DataSourceElement.driver";
    public static final String DB_URL = "DataSourceElement.dbUrl";
    public static final String USERNAME = "DataSourceElement.username";
    public static final String PASSWORD = "DataSourceElement.password";
    public static final String CHECK_QUERY = "DataSourceElement.checkQuery";
    public static final String POOL_MAX = "DataSourceElement.poolMax";
    public static final String CONNECTION_AGE = "DataSourceElement.connectionAge";
    public static final String TIMEOUT = "DataSourceElement.timeout";
    public static final String TRIM_INTERVAL = "DataSourceElement.trimInterval";
    public static final String TRANSACTION_ISOLATION = "DataSourceElement.transactionIsolation";
    public static final String AUTO_COMMIT = "DataSourceElement.autocommit";
    public static final String KEEP_ALIVE = "DataSourceElement.keepAlive";
    

    /*
     *  The datasource is set up by testStarted and cleared by testEnded.
     *  These are called from different threads, so access must be synchronized.
     *  The same instance is called in each case.
    */
    private transient BasicDataSource dbcpDataSource;

    // Keep a record of the pre-thread pools so that they can be disposed of at the end of a test
    private transient Set<BasicDataSource> perThreadPoolSet;

    public DataSourceElement() {
    }

    @Override
    public void testEnded() {
        synchronized (this) {
            if (dbcpDataSource != null) {
                try {
                    dbcpDataSource.close();
                } catch (SQLException ex) {
                    log.error("Error closing pool:"+getName(), ex);
                }
            }
            dbcpDataSource = null;
        }
        if (perThreadPoolSet != null) {// in case
            for(BasicDataSource dsc : perThreadPoolSet){
                log.debug("Closing pool: "+ getDataSourceName()+" @"+System.identityHashCode(dsc));
                try {
                    dsc.close();
                } catch (SQLException ex) {
                    log.error("Error closing pool:"+getName(), ex);
                }
            }
            perThreadPoolSet=null;
        }
    }

    @Override
    public void testEnded(String host) {
        testEnded();
    }

    @Override
    public void testStarted() {
        this.setRunningVersion(true);
        TestBeanHelper.prepare(this);
        JMeterVariables variables = getThreadContext().getVariables();
        String poolName = getDataSource();
        if(JOrphanUtils.isBlank(poolName)) {
            throw new IllegalArgumentException("Variable Name must not be empty for element:"+getName());
        } else if (variables.getObject(poolName) != null) {
            log.error("JDBC data source already defined for: "+poolName);
        } else {
            String maxPool = getPoolMax();
            perThreadPoolSet = Collections.synchronizedSet(new HashSet<BasicDataSource>());
            if (maxPool.equals("0")){ // i.e. if we want per thread pooling
                variables.putObject(poolName, new DataSourceComponentImpl()); // pool will be created later
            } else {
                BasicDataSource src = initPool(maxPool);
                synchronized(this){
                    dbcpDataSource = src;
                    variables.putObject(poolName, new DataSourceComponentImpl(dbcpDataSource));
                }
            }
        }
    }

    @Override
    public void testStarted(String host) {
        testStarted();
    }

    @Override
    public Object clone() {
        DataSourceElement el = (DataSourceElement) super.clone();
        synchronized (this) {
            el.dbcpDataSource = dbcpDataSource;
            el.perThreadPoolSet = perThreadPoolSet;            
        }
        return el;
    }

    /*
     * Utility routine to get the connection from the pool.
     * Purpose:
     * - allows JDBCSampler to be entirely independent of the pooling classes
     * - allows the pool storage mechanism to be changed if necessary
     */
    public static Connection getConnection(String poolName) throws SQLException{
        Object poolObject = 
                JMeterContextService.getContext().getVariables().getObject(poolName);
        if (poolObject == null) {
            throw new SQLException("No pool found named: '" + poolName + "', ensure Variable Name matches Variable Name of JDBC Connection Configuration");
        } else {
            if(poolObject instanceof DataSourceComponentImpl) {
                DataSourceComponentImpl pool = (DataSourceComponentImpl) poolObject;
                return pool.getConnection();    
            } else {
                String errorMsg = "Found object stored under variable:'"+poolName
                        +"' with class:"+poolObject.getClass().getName()+" and value: '"+poolObject+" but it's not a DataSourceComponent, check you're not already using this name as another variable";
                log.error(errorMsg);
                throw new SQLException(errorMsg); 
            }
        }
    }

    /*
     * Set up the DataSource - maxPool is a parameter, so the same code can
     * also be used for setting up the per-thread pools.
    */
    private BasicDataSource initPool(String maxPool) {
        BasicDataSource dataSource = new BasicDataSource();

        if (log.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder(40);
            sb.append("MaxPool: ");
            sb.append(maxPool);
            sb.append(" Timeout: ");
            sb.append(getTimeout());
            sb.append(" TrimInt: ");
            sb.append(getTrimInterval());
            sb.append(" Auto-Commit: ");
            sb.append(isAutocommit());
            log.debug(sb.toString());
        }
        int poolSize = Integer.parseInt(maxPool);
        dataSource.setMinIdle(0);
        dataSource.setInitialSize(poolSize);
        dataSource.setMaxIdle(poolSize);
        dataSource.setMaxTotal(poolSize);
        dataSource.setMaxWaitMillis(Long.parseLong(getTimeout()));

        dataSource.setDefaultAutoCommit(Boolean.valueOf(isAutocommit()));

        if (log.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder(40);
            sb.append("KeepAlive: ");
            sb.append(isKeepAlive());
            sb.append(" Age: ");
            sb.append(getConnectionAge());
            sb.append(" CheckQuery: ");
            sb.append(getCheckQuery());
            log.debug(sb.toString());
        }
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestOnCreate(false);
        dataSource.setTestWhileIdle(false);

        if(isKeepAlive()) {
            dataSource.setTestWhileIdle(true);
            dataSource.setValidationQuery(getCheckQuery());
            dataSource.setSoftMinEvictableIdleTimeMillis(Long.parseLong(getConnectionAge()));
            dataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(getTrimInterval()));
        }

        int transactionIsolation = DataSourceElementBeanInfo.getTransactionIsolationMode(getTransactionIsolation());
        if (transactionIsolation >= 0) {
            dataSource.setDefaultTransactionIsolation(transactionIsolation);
        }

        String _username = getUsername();
        if (log.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder(40);
            sb.append("Driver: ");
            sb.append(getDriver());
            sb.append(" DbUrl: ");
            sb.append(getDbUrl());
            sb.append(" User: ");
            sb.append(_username);
            log.debug(sb.toString());
        }
        dataSource.setDriverClassName(getDriver());
        dataSource.setUrl(getDbUrl());

        if (_username.length() > 0){
            dataSource.setUsername(_username);
            dataSource.setPassword(getPassword());
        }

        // log is required to ensure errors are available
        //source.enableLogging(new LogKitLogger(log));
        if(log.isDebugEnabled()) {
            log.debug("PoolConfiguration:"+this.getDataSource());
        }
        return dataSource;
    }

    // used to hold per-thread singleton connection pools
    private static final ThreadLocal<Map<String, BasicDataSource>> perThreadPoolMap =
        new ThreadLocal<Map<String, BasicDataSource>>(){
        @Override
        protected Map<String, BasicDataSource> initialValue() {
            return new HashMap<>();
        }
    };

    /*
     * Wrapper class to allow getConnection() to be implemented for both shared
     * and per-thread pools.
     *
     */
    private class DataSourceComponentImpl {

        private final BasicDataSource sharedDSC;

        DataSourceComponentImpl(){
            sharedDSC=null;
        }

        DataSourceComponentImpl(BasicDataSource p_dsc){
            sharedDSC=p_dsc;
        }

        /**
         * @return Connection
         * @throws SQLException if database access error occurrs
         */
        public Connection getConnection() throws SQLException {
            Connection conn = null;
            BasicDataSource dsc = null;
            if (sharedDSC != null){ // i.e. shared pool
                dsc = sharedDSC;
            } else {
                Map<String, BasicDataSource> poolMap = perThreadPoolMap.get();
                dsc = poolMap.get(getDataSourceName());
                if (dsc == null){
                    dsc = initPool("1");
                    poolMap.put(getDataSourceName(),dsc);
                    log.debug("Storing pool: "+getName()+" @"+System.identityHashCode(dsc));
                    perThreadPoolSet.add(dsc);
                }
            }
            if (dsc != null) {
                conn=dsc.getConnection();
                int transactionIsolation = DataSourceElementBeanInfo.getTransactionIsolationMode(getTransactionIsolation());
                if (transactionIsolation >= 0 && conn.getTransactionIsolation() != transactionIsolation) {
                    try {
                        // make sure setting the new isolation mode is done in an auto committed transaction
                        conn.setTransactionIsolation(transactionIsolation);
                        log.debug("Setting transaction isolation: " + transactionIsolation + " @"
                                + System.identityHashCode(dsc));
                    } catch (SQLException ex) {
                        log.error("Could not set transaction isolation: " + transactionIsolation + " @"
                                + System.identityHashCode(dsc));
                    }   
                }
            }
            return conn;
        }
    }

    @Override
    public void addConfigElement(ConfigElement config) {
    }

    @Override
    public boolean expectsModification() {
        return false;
    }

    /**
     * @return Returns the checkQuery.
     */
    public String getCheckQuery() {
        return this.getPropertyAsString(CHECK_QUERY);
    }

    /**
     * @param checkQuery
     *            The checkQuery to set.
     */
    public void setCheckQuery(String checkQuery) {
        this.setProperty(CHECK_QUERY, checkQuery);
    }

    /**
     * @return Returns the connectionAge.
     */
    public String getConnectionAge() {
        return this.getPropertyAsString(CONNECTION_AGE);
    }

    /**
     * @param connectionAge
     *            The connectionAge to set.
     */
    public void setConnectionAge(String connectionAge) {
        this.setProperty(CONNECTION_AGE, connectionAge);
    }

    /**
     * @return Returns the poolname.
     */
    public String getDataSource() {
        return this.getPropertyAsString(DATA_SOURCE);
    }

    /**
     * @param dataSource
     *            The poolname to set.
     */
    public void setDataSource(String dataSource) {
        this.setProperty(DATA_SOURCE, dataSource);
    }
    
    private String getDataSourceName() {
        return getDataSource();
    }

    /**
     * @return Returns the dbUrl.
     */
    public String getDbUrl() {
        return this.getPropertyAsString(DB_URL);
    }

    /**
     * @param dbUrl
     *            The dbUrl to set.
     */
    public void setDbUrl(String dbUrl) {
        this.setProperty(DB_URL, dbUrl);
    }

    /**
     * @return Returns the driver.
     */
    public String getDriver() {
        return this.getPropertyAsString(DRIVER);
    }

    /**
     * @param driver
     *            The driver to set.
     */
    public void setDriver(String driver) {
        this.setProperty(DRIVER, driver);
    }

    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return this.getPropertyAsString(PASSWORD);
    }

    /**
     * @param password
     *            The password to set.
     */
    public void setPassword(String password) {
        this.setProperty(PASSWORD, password);
    }

    /**
     * @return Returns the poolMax.
     */
    public String getPoolMax() {
        return this.getPropertyAsString(POOL_MAX);
    }

    /**
     * @param poolMax
     *            The poolMax to set.
     */
    public void setPoolMax(String poolMax) {
        this.setProperty(POOL_MAX, poolMax);
    }

    /**
     * @return Returns the timeout.
     */
    public String getTimeout() {
        return this.getPropertyAsString(TIMEOUT);
    }

    /**
     * @param timeout
     *            The timeout to set.
     */
    public void setTimeout(String timeout) {
        this.setProperty(TIMEOUT, timeout);
    }

    /**
     * @return Returns the trimInterval.
     */
    public String getTrimInterval() {
        return this.getPropertyAsString(TRIM_INTERVAL);
    }

    /**
     * @param trimInterval
     *            The trimInterval to set.
     */
    public void setTrimInterval(String trimInterval) {
        this.setProperty(TRIM_INTERVAL, trimInterval);
    }

    /**
     * @return Returns the username.
     */
    public String getUsername() {
        return this.getPropertyAsString(USERNAME);
    }

    /**
     * @param username
     *            The username to set.
     */
    public void setUsername(String username) {
        this.setProperty(USERNAME, username);
    }

    /**
     * @return Returns the autocommit.
     */
    public boolean isAutocommit() {
        return this.getPropertyAsBoolean(AUTO_COMMIT);
       
    }

    /**
     * @param autocommit
     *            The autocommit to set.
     */
    public void setAutocommit(boolean autocommit) {
        this.setProperty(AUTO_COMMIT, autocommit);
    }

    /**
     * @return Returns the keepAlive.
     */
    public boolean isKeepAlive() {
        return this.getPropertyAsBoolean(KEEP_ALIVE);
    }

    /**
     * @param keepAlive
     *            The keepAlive to set.
     */
    public void setKeepAlive(boolean keepAlive) {
        this.setProperty(KEEP_ALIVE, keepAlive);
    }

    /**
     * @return the transaction isolation level
     */
    public String getTransactionIsolation() {
        return this.getPropertyAsString(TRANSACTION_ISOLATION);
    }

    /**
     * @param transactionIsolation The transaction isolation level to set. <code>NULL</code> to
     * use the default of the driver.
     */
    public void setTransactionIsolation(String transactionIsolation) {
    	this.setProperty(TRANSACTION_ISOLATION, transactionIsolation);
    }
}
