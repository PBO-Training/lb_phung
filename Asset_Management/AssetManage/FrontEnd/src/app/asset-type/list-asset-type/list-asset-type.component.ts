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
  SearchType: any;
  id: number;
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
  // searchType(value: string) {
  //   this.assetTypeService.getAssetTypesList(value).subscribe(
  //     (search) => {
  //       this.reloadData();
  //     },
  //     (error) => console.log(error)
  //   );
  // }
  // tslint:disable-next-line: typedef
  // deleteAssetType(assetTypeid: number) {
  //   this.assetTypeService.deleteAssetType(assetTypeid).subscribe(
  //     (data) => {
  //       console.log(data);
  //       this.reloadData();
  //     },
  //     (error) => console.log(error)
  //   );
  // }
  // // tslint:disable-next-line: typedef
  // assetTypeDetails(assetTypeid: number) {
  //   this.router.navigate(['details', assetTypeid]);
  // }
  // // tslint:disable-next-line: typedef
  // assetTypeUpdate(assetTypeid: number) {
  //   this.router.navigate(['update', assetTypeid]);
  // }
}
