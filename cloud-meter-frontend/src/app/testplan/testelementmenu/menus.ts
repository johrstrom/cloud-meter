
import {TestElementNode} from '../testelement';

export const ThreadGroupOptions = [
  {
    enabled: true,
    visible: true,
    label: 'ThreadGroup',
    click: (event, item) => {
      console.log("new thread group")
    },
  },
  {
    enabled: true,
    visible: true,
    label:  'SetUp ThreadGroup',
    click: (event, item): void => {
      console.log("new setup thread group")
    },
  },
  {
    enabled: true,
    visible: true,
    label: 'TearDown ThreadGroup',
    click: (event, item) => {
      console.log("new tear down thread group")
    },
  },
];

export const SamplerOptions = [
  {
    enabled: true,
    visible: true,
    label: 'Http Sampler',
    click: (event, item) => {
      console.log("new thread group")
    },
  },
  {
    enabled: true,
    visible: true,
    label:  'JSR223 Sampler',
    click: (event, item): void => {
      console.log("new setup thread group")
    },
  },
  {
    enabled: true,
    visible: true,
    label: 'Third Sampler',
    click: (event, item) => {
      console.log("new tear down thread group")
    },
  },
];

export const TopLevelOptions = [
  {
    enabled: true,
    visible: true,
    label:  'Add',
    click:(event, item) => {
      console.log("trying to add something")
    },
    subActions: ThreadGroupOptions,
  },
  {
    enabled: true,
    visible: true,
    label:  'Delete',
    click:(event, item) => {
      console.log("trying to delete something")
    },
    subActions: SamplerOptions,
  },
];
