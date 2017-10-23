import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TestplanComponent } from './testplan/testplan.component';
import { TestElementComponent } from './testplan/testelement.component';
import { TopNavBarComponent } from './common/topnavbar.component';
import { SidebarModule } from 'ng-sidebar';

import { BackendService } from './backend.service';

@NgModule({
  declarations: [
    AppComponent,
    TestplanComponent,
    TestElementComponent,
  ],
  imports: [
    BrowserModule,
    SidebarModule.forRoot(),
    FormsModule
  ],
  providers: [
    BackendService,
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
