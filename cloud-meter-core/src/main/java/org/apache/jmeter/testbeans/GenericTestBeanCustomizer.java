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
package org.apache.jmeter.testbeans;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.apache.commons.lang3.ClassUtils;
import org.apache.jmeter.util.JMeterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The GenericTestBeanCustomizer is designed to provide developers with a
 * mechanism to quickly implement GUIs for new components.
 * <p>
 * It allows editing each of the public exposed properties of the edited type 'a
 * la JavaBeans': as far as the types of those properties have an associated
 * editor, there's no GUI development required.
 * <p>
 * This class understands the following PropertyDescriptor attributes:
 * <dl>
 * <dt>group: String</dt>
 * <dd>Group under which the property should be shown in the GUI. The string is
 * also used as a group title (but see comment on resourceBundle below). The
 * default group is "".</dd>
 * <dt>order: Integer</dt>
 * <dd>Order in which the property will be shown in its group. A smaller
 * integer means higher up in the GUI. The default order is 0. Properties of
 * equal order are sorted alphabetically.</dd>
 * <dt>tags: String[]</dt>
 * <dd>List of values to be offered for the property in addition to those
 * offered by its property editor.</dd>
 * <dt>notUndefined: Boolean</dt>
 * <dd>If true, the property should not be left undefined. A <b>default</b>
 * attribute must be provided if this is set.</dd>
 * <dt>notExpression: Boolean</dt>
 * <dd>If true, the property content should always be constant: JMeter
 * 'expressions' (strings using ${var}, etc...) can't be used.</dd>
 * <dt>notOther: Boolean</dt>
 * <dd>If true, the property content must always be one of the tags values or
 * null.</dd>
 * <dt>default: Object</dt>
 * <dd>Initial value for the property's GUI. Must be provided and be non-null
 * if <b>notUndefined</b> is set. Must be one of the provided tags (or null) if
 * <b>notOther</b> is set.
 * </dl>
 * <p>
 * The following BeanDescriptor attributes are also understood:
 * <dl>
 * <dt>group.<i>group</i>.order: Integer</dt>
 * <dd>where <b><i>group</i></b> is a group name used in a <b>group</b>
 * attribute in one or more PropertyDescriptors. Defines the order in which the
 * group will be shown in the GUI. A smaller integer means higher up in the GUI.
 * The default order is 0. Groups of equal order are sorted alphabetically.</dd>
 * <dt>resourceBundle: ResourceBundle</dt>
 * <dd>A resource bundle to be used for GUI localization: group display names
 * will be obtained from property "<b><i>group</i>.displayName</b>" if
 * available (where <b><i>group</i></b> is the group name).
 * </dl>
 */
public class GenericTestBeanCustomizer {
    private static final long serialVersionUID = 240L;

    private static final Logger log = LoggerFactory.getLogger(GenericTestBeanCustomizer.class);


    public static final String GROUP = "group"; //$NON-NLS-1$

    public static final String ORDER = "order"; //$NON-NLS-1$

    /**
     * Array of permissible values.
     * <p>
     * Must be provided if:
     * <ul>
     * <li>{@link #NOT_OTHER} is TRUE, and</li>
     * <li>{@link PropertyEditor#getTags()} is null</li>
     * </ul>
     */
    public static final String TAGS = "tags"; //$NON-NLS-1$

    /** 
     * Whether the field must be defined (i.e. is required); 
     * Boolean, defaults to FALSE
     */
    public static final String NOT_UNDEFINED = "notUndefined"; //$NON-NLS-1$

    /** Whether the field disallows JMeter expressions; Boolean, default FALSE */
    public static final String NOT_EXPRESSION = "notExpression"; //$NON-NLS-1$

    /** Whether the field disallows constant values different from the provided tags; Boolean, default FALSE */
    public static final String NOT_OTHER = "notOther"; //$NON-NLS-1$

    /** If specified, create a multi-line editor */
    public static final String MULTILINE = "multiline";

    /** Default value, must be provided if {@link #NOT_UNDEFINED} is TRUE */
    public static final String DEFAULT = "default"; //$NON-NLS-1$

    /** Default value is not saved; only non-defaults are saved */
    public static final String DEFAULT_NOT_SAVED = "defaultNoSave"; //$NON-NLS-1$

    /** Pointer to the resource bundle, if any (will generally be null) */
    public static final String RESOURCE_BUNDLE = "resourceBundle"; //$NON-NLS-1$

    /** Property editor override; must be an enum of type {@link TypeEditor} */
    public static final String GUITYPE = "guiType"; // $NON-NLS-$

    /** TextEditor property */
    public static final String TEXT_LANGUAGE = "textLanguage"; //$NON-NLS-1$



    public static final String DEFAULT_GROUP = "";


}
