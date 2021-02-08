import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule,  } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DemoMaterialModule } from './nav-bar/material-module';

import { CreateAssetTypeComponent } from './asset-type/create-asset-type/create-asset-type.component';
import { DetailAssetTypeComponent } from './asset-type/detail-asset-type/detail-asset-type.component';
import { ListAssetTypeComponent } from './asset-type/list-asset-type/list-asset-type.component';
import { UpdateAssetTypeComponent } from './asset-type/update-asset-type/update-asset-type.component';
import { CreateAssetComponent } from './asset/create-asset/create-asset.component';
import { DetailAssetComponent } from './asset/detail-asset/detail-asset.component';
import { ListAssetComponent } from './asset/list-asset/list-asset.component';
import { UpdateAssetComponent } from './asset/update-asset/update-asset.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { TableComponent } from './share/table/table.component';
import { SearchComponent } from './share/search/search.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



@NgModule({
  declarations: [
    AppComponent,
    CreateAssetTypeComponent,
    DetailAssetTypeComponent,
    ListAssetTypeComponent,
    UpdateAssetTypeComponent,
    CreateAssetComponent,
    DetailAssetComponent,
    ListAssetComponent,
    UpdateAssetComponent,
    NavBarComponent,
    TableComponent,
    SearchComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DemoMaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
