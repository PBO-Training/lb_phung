import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListAssetTypeComponent } from '../app/asset-type/list-asset-type/list-asset-type.component';
import { DetailAssetTypeComponent } from '../app/asset-type/detail-asset-type/detail-asset-type.component';
import { UpdateAssetTypeComponent } from '../app/asset-type/update-asset-type/update-asset-type.component';
import { CreateAssetTypeComponent } from '../app/asset-type/create-asset-type/create-asset-type.component';
import { ListAssetComponent } from '../app/asset/list-asset/list-asset.component';
import { DetailAssetComponent } from '../app/asset/detail-asset/detail-asset.component';
import { UpdateAssetComponent } from '../app/asset/update-asset/update-asset.component';
import { CreateAssetComponent } from '../app/asset/create-asset/create-asset.component';
import { NavBarComponent } from '../app/nav-bar/nav-bar.component';
import { SearchComponent } from './share/search/search.component';
import { TableComponent } from './share/table/table.component';

const routes: Routes = [
  { path: '', redirectTo: 'assetType', pathMatch: 'full' },
  { path: '', redirectTo: 'asset', pathMatch: 'full' },
  { path: 'listAssetTypes', component: ListAssetTypeComponent },
  { path: 'addAssetType', component: CreateAssetTypeComponent },
  { path: 'updateAssetType/:assetTypeId', component: UpdateAssetTypeComponent },
  { path: 'detailsAssetType/:assetTypeId', component: DetailAssetTypeComponent },
  { path: 'listAsset', component: ListAssetComponent },
  { path: 'addAsset', component: CreateAssetComponent },
  { path: 'updateAsset/:assetId', component: UpdateAssetComponent },
  { path: 'detailsAsset/:assetId', component: DetailAssetComponent },
  { path: 'search', component: SearchComponent },
  { path: 'table', component: TableComponent },
  { path: 'navbar', component: NavBarComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
