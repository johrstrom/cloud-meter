
import {TestElementNode} from '../testelement';

export const ThreadGroupMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) =>  'ThreadGroup',
    click: (item, event) => {
      console.log("new thread group")
    },
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html:  (item: any) => 'SetUp ThreadGroup',
    click: (item, event): void => {
      console.log("new setup thread group")
    },
  },
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'TearDown ThreadGroup',
    click: (item, event) => {
      console.log("new tear down thread group")
    },
  },
];

export const TopLevelMenu = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Add',
    click: (item, event) => {},
    subMenus: [{
      enabled: true,
      visible: (item: any) => true,
      html: (item: any) => 'ThreadGroups',
      click: (item, event) => {},
      subMenus: ThreadGroupMenu
    }],
  },
];
