/**
 * The TestElement class
 */

export class TestElement {
  properties:  Map<string, string>;

  constructor() {
    this.properties = new Map<string, string>();
  }

  setName(name: string) {
    return this.properties.set('TestElement.name', name);
  }

  getName() {
    return this.properties.get('TestElement.name');
  }

}

export class TestElementNode {
  element: TestElement;
  subTree: TestElement[];
  elementType: string;

  getName() {
    return this.element.getName();
  }

}


