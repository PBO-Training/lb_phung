import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';  
import { HttpClientModule } from '@angular/common/http';

import { CreateAssetTypeComponent } from './create-asset-type/create-asset-type.component';
import { DetailAssetTypeComponent } from './detail-asset-type/detail-asset-type.component';
import { ListAssetTypeComponent } from './list-asset-type/list-asset-type.component';
import { UpdateAssetTypeComponent } from './update-asset-type/update-asset-type.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateAssetTypeComponent,
    DetailAssetTypeComponent,
    ListAssetTypeComponent,
    UpdateAssetTypeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
     
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
