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

import org.apache.jmeter.testbeans.BeanInfoSupport;

public class CSVDataSetBeanInfo extends BeanInfoSupport {


    // Access needed from CSVDataSet
    static final String[] SHARE_TAGS = new String[3];
    static final int SHARE_ALL    = 0;
    static final int SHARE_GROUP  = 1;
    static final int SHARE_THREAD = 2;

    // Store the resource keys
    static {
        SHARE_TAGS[SHARE_ALL]    = "shareMode.all"; //$NON-NLS-1$
        SHARE_TAGS[SHARE_GROUP]  = "shareMode.group"; //$NON-NLS-1$
        SHARE_TAGS[SHARE_THREAD] = "shareMode.thread"; //$NON-NLS-1$        
    }

    public CSVDataSetBeanInfo() {
        super(CSVDataSet.class);
    }

	public static int getShareModeAsInt(String mode) {
		// TODO Auto-generated method stub
		return 0;
	}

 
}
