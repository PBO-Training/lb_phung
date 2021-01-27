import { Component, OnInit } from '@angular/core';
import { AssetType } from '../../Entity/assetType';
import { AssetTypeService } from '../../asset-type.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  assetTypes: Observable<AssetType[]>;
  constructor(
    private assetTypeService: AssetTypeService,
    private router: Router
  ) {}

  // tslint:disable-next-line: typedef
  ngOnInit() {
    this.reloadData();
  }
  // tslint:disable-next-line: typedef
  reloadData() {
    this.assetTypes = this.assetTypeService.getAssetTypesList();
  }
  // tslint:disable-next-line: typedef
  deleteAssetType(assetTypeid: number) {
    this.assetTypeService.deleteAssetType(assetTypeid).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }
  // tslint:disable-next-line: typedef
  assetTypeDetails(assetTypeid: number) {
    this.router.navigate(['details', assetTypeid]);
  }
  // tslint:disable-next-line: typedef
  assetTypeUpdate(assetTypeid: number) {
    this.router.navigate(['update', assetTypeid]);
  }
}
