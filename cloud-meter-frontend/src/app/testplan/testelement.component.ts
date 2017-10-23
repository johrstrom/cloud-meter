/**
 * The TestElement class
 */
import { Component } from '@angular/core';
import { TestElement } from './testelement';

@Component({
  selector: 'app-testelement',
  templateUrl: './testelement.component.html',
  styleUrls: ['./testplan.component.css'],
})

export class TestElementComponent {
  element: TestElement;

  constructor() {
    this.element = new TestElement();
  }

}

