import { Component, OnInit, Output } from '@angular/core';
import { AssetType } from '../../Entity/assetType';
import { AssetTypeService } from '../../asset-type.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-list-asset-type',
  templateUrl: './list-asset-type.component.html',
  styleUrls: ['./list-asset-type.component.css'],
})
export class ListAssetTypeComponent implements OnInit {
  // @Output() SearchType: string;
  assetTypes: AssetType[];
  assetTypeName: string;


  constructor(
    private assetTypeService: AssetTypeService,
    private router: Router
  ) {}

  ngOnInit() {
    this.reloadData();
    //this.SearchType();
  }
  // getById(assetTypeId: number) {
  //   this.assetTypeService.getAssetTypeId();
  // }
  // tslint:disable-next-line: typedef
  reloadData() {
    this.assetTypeService.getAssetTypesList().subscribe(
      (list) => {
        this.assetTypes = list;

      },
      (error) => console.log(error)
    );
    //console.log(this.assetTypes);
  }
  searchByName(assetTypeName: string) {
    this.assetTypeService.searchByName(assetTypeName).subscribe(
      (search) => {
        console.log(search);
        this.assetTypeName=search;
      },
      (error) => console.log(error)
    );
  }





  deleteAssetType(assetTypeid: number) {
    this.assetTypeService.deleteAssetType(assetTypeid).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  assetTypeDetails(assetTypeid: number) {
    this.router.navigate(['details', assetTypeid]);
  }

  assetTypeUpdate(assetTypeid: number) {
    this.router.navigate(['update', assetTypeid]);
  }
}
