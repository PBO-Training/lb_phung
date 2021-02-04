import {
  Component,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { AssetType } from '../../Entity/assetType';
import { AssetTypeService } from '../../asset-type.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-list-asset-type',
  templateUrl: './list-asset-type.component.html',
  styleUrls: ['./list-asset-type.component.css'],
})
export class ListAssetTypeComponent implements OnInit, OnChanges {
  assetTypeTable: AssetType[];
  assetTypeReq: AssetType;
  columnTables = ['Code', 'Name'];
  fieldName = ['assetTypeCode', 'assetTypeName'];
  assetTypeId = 'assetTypeId';

  constructor(
    private assetTypeService: AssetTypeService,
    private router: Router
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    // this.assetTypes = changes.assetTypeName.currentValue;
    throw new Error('Method not implemented.');
  }

  ngOnInit() {
    this.reloadData();
  }
  reloadData(): void {
    this.assetTypeService.getAssetTypesList().subscribe(
      (list) => {
        console.log(list);

        this.assetTypeTable = list;
      },
      (error) => console.log(error)
    );
  }

  searchByName(value: string): void {
    console.log(this.searchByName);

    this.assetTypeReq = {
      ...this.assetTypeReq,
      assetTypeName: value,
    };
    this.assetTypeService.searchNameAssetType(this.assetTypeReq).subscribe(
      (search) => {
        this.assetTypeTable = search;
      },
      (error) => console.log(error)
    );
  }

  searchByCode(value: string): void {
    this.assetTypeReq = {
      ...this.assetTypeReq,
      assetTypeCode: value,
    };
    this.assetTypeService.searchCodeAssetType(this.assetTypeReq).subscribe(
      (search) => {
        this.assetTypeTable = search;
      },
      (error) => console.log(error)
    );
  }

  deleteAssetType(body: number) {
    this.assetTypeService.deleteAssetType(body).subscribe(
      (data) => {
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  assetTypeDetails(assetTypeid: number, action: string) {
    console.log("sss",assetTypeid);
    // console.log(action);

    this.router.navigate(['details', assetTypeid, action]);
  }

  assetTypeUpdate(assetTypeid: number) {
    this.router.navigate(['update', assetTypeid]);
  }
}
