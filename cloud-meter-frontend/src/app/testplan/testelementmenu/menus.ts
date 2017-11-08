
import {TestElementNode} from '../testelement';

export const ThreadGroupMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'ThreadGroup',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html:  (item: any) => 'SetUp ThreadGroup',
    click: (item, event): void => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'TearDown ThreadGroup',
    click: (item, event) => {},
  },
];

export const LogicControllerMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Critical Section Controller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html:  (item: any) => 'ForEach Controller',
    click: (item, event): void => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'If Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Include Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Loop Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Once Only Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Random Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Random Order Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Switch Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Throughput Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Transaction Cpntroller',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'While Cpntroller',
    click: (item, event) => {},
  },
];

export const ConfigElementMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Counter',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html:  (item: any) => 'CSV Data Set Config',
    click: (item, event): void => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'FTP Request Defaults',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'HTTP Authorization Manager',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'HTTP Cache Manager',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'HTTP Cookie Manager',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'HTTP Header Manager',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'HTTP Request Defaults',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Java Requst Defaults',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'JDBC Connection Configuration',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Keystore Configuration',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'LDAP Extended Request Defaults',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'LDAP Request Defaults',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Login Config Element',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Random Variable',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Simple Config Element',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'TCP Sampler Config',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'User Defined Variables',
    click: (item, event) => {},
  },
];

export const TimerMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'BeanShell Timer',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html:  (item: any) => 'Constant Throughput Timer',
    click: (item, event): void => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Constant Timer',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Gaussian Random Timer',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'JSR223 Timer',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Poisson Random Timer',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Synchronizing Timer',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Uniform Random Timer',
    click: (item, event) => {},
  },
];

export const PreProcessorMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'BeanShell PreProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html:  (item: any) => 'HTML Link Parser',
    click: (item, event): void => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'HTTP URL Re-writing Modifier',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'JDBC PreProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'JSR223 PreProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Regex User Parameters',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Sample Timeout',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'User Parameters',
    click: (item, event) => {},
  },
];

export const SamplerMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Access Log Sampler',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html:  (item: any) => 'AJP/1.3 Sampler',
    click: (item, event): void => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Debug Sampler',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'HTTP Request',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Java Request',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Java Request',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'JDBC Request',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'LDAP Extended Request',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'LDAP Request',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Mail reader Sampler',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'OS Process Sampler',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'SMTP Sampler',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'TCP Sampler',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Test Action',
    click: (item, event) => {},
  },
];

export const PostProcessorMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'BeanShell PostProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'CSS/JQuery PostProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Debug PostProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'JDBC PostProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'JSON PostProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'JSR223 PostProcessor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Regular Expression Extractor',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Result Status Action Handler',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'XPath Extractor',
    click: (item, event) => {},
  },
]
export const AssertionMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'BeanShell Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Compare Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Duration Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'HTML Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'JSR223 Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'MD5Hex Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Response Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'Size Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'SMIME Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'XML Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'XML Schema Assertion',
    click: (item, event) => {},
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'XPath Assertion',
    click: (item, event) => {},
  },
]

export const TopLevelMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Add',
    click: (item, event) => {},
    subMenus: [
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'ThreadGroups',
        click: (item, event) => {},
        subMenus: ThreadGroupMenu
      },
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'Logic Controllers',
        click: (item, event) => {},
        subMenus: LogicControllerMenu
      },
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'Config Element',
        click: (item, event) => {},
        subMenus: ConfigElementMenu
      },
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'Timer',
        click: (item, event) => {},
        subMenus: TimerMenu
      },
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'Pre Proccessor',
        click: (item, event) => {},
        subMenus: PreProcessorMenu
      },
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'Sampler',
        click: (item, event) => {},
        subMenus: SamplerMenu
      },
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'Post Proccessor',
        click: (item, event) => {},
        subMenus: PostProcessorMenu
      },
      {
        enabled: true,
        visible: (item: any) => true,
        html: (item: any) => 'Assertion',
        click: (item, event) => {},
        subMenus: AssertionMenu
      },
    ],
  },
];
