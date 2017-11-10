/**
 * The Testplan Component
 */
import { Component, ViewChild } from '@angular/core';

import { TestElement, TestElementNode } from './testelement';
import {ContextMenuService ,ContextMenuComponent} from 'ngx-contextmenu';
import { MenuProvider } from './testelementmenu/menus';

@Component({
  selector: 'app-testplan',
  templateUrl: './testplan.component.html',
  styleUrls: ['./testplan.component.css'],
  providers: [ ContextMenuService, MenuProvider ]
})

export class TestplanComponent  {
  testplan: TestElementNode[];
  selectedNode: TestElementNode;

  @ViewChild(ContextMenuComponent) public contextMenu: ContextMenuComponent;

  constructor(
    private contextMenuService: ContextMenuService,
    private menuOptions: MenuProvider
    ) {
    this.testplan = this.defaultTestPlan();
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

  private defaultTestPlan() {
    const tp: TestElementNode[] = [];

    let node = new TestElementNode();
    node.elementType = 'testplan';
    node.element = new TestElement();
    node.setName('TestPlan');
    node.menus = this.menuOptions.getMenuForItem('TestPlan');
    tp[0] = node;

    node = new TestElementNode();
    node.elementType = 'workbench';
    node.element = new TestElement();
    node.setName('WorkBench');
    node.menus = this.menuOptions.getMenuForItem('WorkBench');
    tp[1] = node;


    return tp;
  }

}
