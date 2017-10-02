/**
 * The Testplan Component
 */
import { BackendService } from '../backend.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-testplan',
  templateUrl: './testplan.component.html',
  styleUrls: ['./testplan.component.css'],
  providers: [BackendService]
})

export class TestplanComponent {}
