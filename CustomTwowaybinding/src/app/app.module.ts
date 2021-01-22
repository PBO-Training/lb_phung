import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TwoWayBinDingComponent } from './two-way-bin-ding/two-way-bin-ding.component';
import { ChildTwoWayComponent } from './two-way-bin-ding/child-two-way/child-two-way.component';

@NgModule({
  declarations: [
    AppComponent,   
    TwoWayBinDingComponent,
    ChildTwoWayComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
