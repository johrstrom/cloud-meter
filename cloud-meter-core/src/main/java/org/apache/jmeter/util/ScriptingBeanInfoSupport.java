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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditorSupport;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.swing.JCheckBox;

import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;

/**
 * Parent class to define common GUI parameters for BSF and JSR223 test elements
 */
public abstract class ScriptingBeanInfoSupport extends BeanInfoSupport {

    public ScriptingBeanInfoSupport(Class<? extends TestBean> beanClass, String[] languageTags) {
        this(beanClass, languageTags, null);
    }

    protected ScriptingBeanInfoSupport(Class<? extends TestBean> beanClass, String[] languageTags, ResourceBundle rb) {
        super(beanClass);

        
    }
    
    public static class JSR223ScriptCacheCheckboxEditor extends PropertyEditorSupport implements ActionListener {

        private final JCheckBox checkbox;

        /**
         * Value on which we started the editing.
         */
        private String initialValue = null;

        public JSR223ScriptCacheCheckboxEditor() {
            super();

            checkbox = new JCheckBox();
            checkbox.addActionListener(this);
        }

        @Override
        public String getAsText() {
            String value = null;
            if(checkbox.isSelected()) {
                if(initialValue != null) {
                    value = initialValue;
                }
                else {
                    // the value is unique -> if the script is opened with a previous version of jmeter
                    // where the cache key is used as the key for the cache
                    // in the current version the key is automatically generated from the script content
                    value = UUID.randomUUID().toString();
                }
            }
            
            return value;
        }

        @Override
        public void setAsText(String value) {
            if(StringUtils.isNotBlank(value)) {
                initialValue = value;                
            }
            checkbox.setSelected(initialValue!= null);
        }

        @Override
        public Object getValue() {
            return getAsText();
        }

        @Override
        public void setValue(Object value) {
            if (value instanceof String) {
                setAsText((String) value);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override
        public Component getCustomEditor() {
            return checkbox;
        }

        @Override
        public void firePropertyChange() {
            String newValue = getAsText();

            if (initialValue != null && initialValue.equals(newValue)) {
                return;
            }
            initialValue = newValue;

            super.firePropertyChange();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            firePropertyChange();
        }

        @Override
        public boolean supportsCustomEditor() {
            return true;
        }

     
    }
}
