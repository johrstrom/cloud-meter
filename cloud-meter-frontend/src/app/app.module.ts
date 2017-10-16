import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestplanComponent } from './testplan/testplan.component';
import { TopNavBarComponent } from './common/topnavbar.component';
import { SidebarModule } from 'ng-sidebar';

import { BackendService } from './backend.service';

@NgModule({
  declarations: [
    AppComponent,
    TestplanComponent,
  ],
  imports: [
    BrowserModule,
    SidebarModule.forRoot()
  ],
  providers: [
    BackendService,
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
