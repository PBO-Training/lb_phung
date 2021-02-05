import {
  Component,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { AssetType } from '../../Entity/assetType';
import { AssetTypeService } from '../../service/asset-type.service';
import { ActivatedRoute, Router } from '@angular/router';
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

  assetTypeDelete(value: any) {
    console.log(value);
    if (value.action === 'delete') {

      this.assetTypeService.deleteAssetType(value.value).subscribe(
        (value) => {
          this.reloadData();
        },
        (error) => console.log(error)
      );
    }
  }

  assetTypeDetails(value: any) {
    if (value.action === 'details') {
      this.router.navigate(['details', value.value]);
    }
  }

  assetTypeUpdate(value: any) {
    if (value.action === 'update') {
      this.router.navigate(['update', value.value]);
    }
  }
}
