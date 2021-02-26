import { Component, OnInit } from '@angular/core';
import { DetailAssetTypeComponent } from "../detail-asset-type/detail-asset-type.component";
import { AssetType } from "../assetType";
import { AssetTypeService } from "../asset-type.service";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
@Component({
  selector: 'app-list-asset-type',
  templateUrl: './list-asset-type.component.html',
  styleUrls: ['./list-asset-type.component.css']
})
export class ListAssetTypeComponent implements OnInit {

  assetTypes: Observable<AssetType[]>;

  constructor(
    private assetTypeService: AssetTypeService,
    private router: Router
    ) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
  this.assetTypes = this.assetTypeService.getAssetTypesList();
  }
  deleteAssetType(assetTypeid: number) {
    this.assetTypeService.deleteAssetType(assetTypeid)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
}

  assetTypeDetails(assetTypeid: number){
    this.router.navigate(['details', assetTypeid]);
}
  assetTypeUpdate(assetTypeid: number){
    this.router.navigate(['update', assetTypeid]);
}
}


