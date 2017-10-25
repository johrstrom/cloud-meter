/**
 * The TestElement class
 */
import { Component, Input } from '@angular/core';
import { TestElementNode } from './testelement';

@Component({
  selector: 'app-testelement',
  templateUrl: './testelement.component.html',
  styleUrls: ['./testplan.component.css'],
})

export class TestElementComponent {
  @Input() node: TestElementNode;

  changeName(event) {
    this.node.setName(event);
  }

  changeComments(event) {
    this.node.element.setProperty('TestElement.comments', event);
  }

}

