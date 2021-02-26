import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListAssetTypeComponent } from "../app/list-asset-type/list-asset-type.component";
import { DetailAssetTypeComponent } from "../app/detail-asset-type/detail-asset-type.component";
import { UpdateAssetTypeComponent } from "../app/update-asset-type/update-asset-type.component";
import { CreateAssetTypeComponent } from "../app/create-asset-type/create-asset-type.component";

const routes: Routes = [
  { path: '', redirectTo: 'assetType', pathMatch: 'full' },
  { path: 'listAssetTypes', component: ListAssetTypeComponent },
  { path:'addAssetType',component:CreateAssetTypeComponent},
  { path:'update/:assetTypeId', component: UpdateAssetTypeComponent},
  { path:'details/:assetTypeId', component:DetailAssetTypeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
