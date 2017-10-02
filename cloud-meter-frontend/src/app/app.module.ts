import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestplanComponent } from './testplan/testplan.component';

import { BackendService } from './backend.service';

@NgModule({
  declarations: [
    AppComponent,
    TestplanComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    BackendService,
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
