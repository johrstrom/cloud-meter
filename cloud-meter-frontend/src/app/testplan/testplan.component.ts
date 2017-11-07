/**
 * The Testplan Component
 */
import { BackendService } from '../backend.service';
import { Component, ViewChild } from '@angular/core';

import { TestElement, TestElementNode } from './testelement';
import {ContextMenuService ,ContextMenuComponent} from 'ngx-contextmenu';
import {TopLevelOptions} from './testelementmenu/menus';

@Component({
  selector: 'app-testplan',
  templateUrl: './testplan.component.html',
  styleUrls: ['./testplan.component.css'],
  providers: [ BackendService, ContextMenuService ]
})

export class TestplanComponent  {
  testplan: TestElementNode[];
  selectedNode: TestElementNode;

  @ViewChild(ContextMenuComponent) public contextMenu: ContextMenuComponent;

  constructor(private contextMenuService: ContextMenuService) {
    this.testplan = defaultTestPlan();
  }

  private onSelect(node: TestElementNode) {
    this.selectedNode = node;
  }

  public onContextMenu($event: MouseEvent, item: any): void {
    this.contextMenuService.show.next(
      { event: $event,
        item: item,
        contextMenu: this.contextMenu,
      }
    );

    $event.preventDefault();
    $event.stopPropagation();
    console.log("showing menu on ", item)
  }


}

function defaultTestPlan() {
  const tp: TestElementNode[] = [];

  let node = new TestElementNode();
  node.elementType = 'testplan';
  node.element = new TestElement();
  node.setName('TestPlan');
  node.actions = TopLevelOptions;
  tp[0] = node;

  node = new TestElementNode();
  node.elementType = 'workbench';
  node.element = new TestElement();
  node.setName('WorkBench');
  node.actions = TopLevelOptions;
  tp[1] = node;


  return tp;
}
