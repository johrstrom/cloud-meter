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

package org.apache.jmeter.protocol.jms.control.gui;


/**
 * This is the GUI for JMS Publisher
 *
 */
public class JMSPublisherGui  {

    //++ These names are used in the JMX files, and must not be changed
    /** Take source from the named file */
    public static final String USE_FILE_RSC   = "jms_use_file"; //$NON-NLS-1$
    /** Take source from a random file */
    public static final String USE_RANDOM_RSC = "jms_use_random_file"; //$NON-NLS-1$

    /** Create a TextMessage */
    public static final String TEXT_MSG_RSC = "jms_text_message"; //$NON-NLS-1$
    /** Create a MapMessage */
    public static final String MAP_MSG_RSC = "jms_map_message"; //$NON-NLS-1$
    /** Create an ObjectMessage */
    public static final String OBJECT_MSG_RSC = "jms_object_message"; //$NON-NLS-1$
    /** Create a BytesMessage */
    public static final String BYTES_MSG_RSC = "jms_bytes_message"; //$NON-NLS-1$
    //-- End of names used in JMX files



}
