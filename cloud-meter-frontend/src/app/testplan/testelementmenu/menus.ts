
import {TestElementNode} from '../testelement';

export const TopLevelOptions = [
  {
    enabled: true,
    visible: true,
    html: (item) => 'ThreadGroup',
    execute: (item) => {
      console.log("threadgroup clicked")
    },
  },
];

export const ThreadGroupOptions = [
  {
    html: (item) => 'ThreadGroup',
    click: (item) => {

    },
  },
  {
    html: (item): string => 'SetUp ThreadGroup',
    click: (item): void => {

    },
  },
  {
    html: (item) => 'TearDown ThreadGroup',
    click: (item) => {

    },
  },
];
