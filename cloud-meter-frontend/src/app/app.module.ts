import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TestplanComponent } from './testplan/testplan.component';
import { TestElementComponent } from './testplan/testelement.component';
import { MenuProvider } from './testplan/testelementmenu/menus';
import { TopNavBarComponent } from './common/topnavbar.component';
import { SidebarModule } from 'ng-sidebar';
import { ContextMenuModule } from 'ngx-contextmenu';

import { InquryService } from './inqury.service';

@NgModule({
  declarations: [
    AppComponent,
    TestplanComponent,
    TestElementComponent,
  ],
  imports: [
    BrowserModule,
    SidebarModule.forRoot(),
    FormsModule,
    ContextMenuModule,
    HttpClientModule,
  ],
  providers: [
    InquryService,
    MenuProvider,
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
