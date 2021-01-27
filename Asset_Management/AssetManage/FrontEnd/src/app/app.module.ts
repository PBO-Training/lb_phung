import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { CreateAssetTypeComponent } from './asset-type/create-asset-type/create-asset-type.component';
import { DetailAssetTypeComponent } from './asset-type/detail-asset-type/detail-asset-type.component';
import { ListAssetTypeComponent } from './asset-type/list-asset-type/list-asset-type.component';
import { UpdateAssetTypeComponent } from './asset-type/update-asset-type/update-asset-type.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { TableComponent } from './share/table/table.component';
import { SearchComponent } from './share/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateAssetTypeComponent,
    DetailAssetTypeComponent,
    ListAssetTypeComponent,
    UpdateAssetTypeComponent,
    NavBarComponent,
    TableComponent,
    SearchComponent
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
