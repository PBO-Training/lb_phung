import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { StructureDirectiveComponent } from './structure-directive/structure-directive.component';
// import { ItemDetailComponent } from './item-detail/item-detail.component';
//import { ItemSwitchComponents } from './app-root/item-component';
import { AppRootComponent } from './app-root/app-root.component';
import { ItemDetailComponent } from './app-root/item-detail/item-detail.component';

@NgModule({
  declarations: [
    AppComponent,

    StructureDirectiveComponent,

    // ItemDetailComponent,
    //ItemSwitchComponents,

    AppRootComponent,

    ItemDetailComponent
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
