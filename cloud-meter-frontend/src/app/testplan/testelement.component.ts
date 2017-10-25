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
  @Input() name: string;

  nameChange(event) {
    this.name = event;
    this.node.setName(event);
  }

}

