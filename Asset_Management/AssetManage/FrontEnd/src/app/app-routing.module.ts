import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListAssetTypeComponent } from '../app/asset-type/list-asset-type/list-asset-type.component';
import { DetailAssetTypeComponent } from '../app/asset-type/detail-asset-type/detail-asset-type.component';
import { UpdateAssetTypeComponent } from '../app/asset-type/update-asset-type/update-asset-type.component';
import { CreateAssetTypeComponent } from '../app/asset-type/create-asset-type/create-asset-type.component';
import { SearchComponent } from './share/search/search.component';
import { TableComponent } from './share/table/table.component';

const routes: Routes = [
  { path: '', redirectTo: 'assetType', pathMatch: 'full' },
  { path: 'listAssetTypes', component: ListAssetTypeComponent },
  { path: 'addAssetType', component: CreateAssetTypeComponent },
  { path: 'update/:assetTypeId', component: UpdateAssetTypeComponent },
  { path: 'details/:assetTypeId', component: DetailAssetTypeComponent },
  { path: 'search', component: SearchComponent},
  { path: 'table', component: TableComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
