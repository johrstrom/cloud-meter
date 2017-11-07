
import {TestElementNode} from '../testelement';

export const ThreadGroupOptions = [
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

// export interface ILinkConfig {
//   click: (item: any, $event?: MouseEvent) => void;
//   enabled?: (item: any) => boolean;
//   html: (item: any) => string;
// }

export const TopLevelOptions = [
  {
    enabled: true,
    visible: (item: any) => true,
    html: (item: any) => 'Add',
    click: (item, event) => {
      console.log("trying to add something")
    },
    subActions: ThreadGroupOptions,
  },
  // {
  //   enabled: true,
  //   visible: true,
  //   label:  'Delete',
  //   click:(item, event) => {
  //     console.log("trying to delete something")
  //   },
  //   subActions: SamplerOptions,
  // },
];
