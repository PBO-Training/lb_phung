import {
  Component,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Asset } from '../../Entity/asset';
import { AssetService } from '../../service/asset.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AssetType } from 'src/app/Entity/assetType';
@Component({
  selector: 'app-list-asset',
  templateUrl: './list-asset.component.html',
  styleUrls: ['./list-asset.component.css'],
})
export class ListAssetComponent implements OnInit, OnChanges {
  assetTable: Asset[];
  assetType: AssetType[];
  assetReq: Asset;
  columnTables = ['Name', 'Date of purchase ', 'Price($)', 'Asset Type'];
  fieldName = ['assetName', 'assetDayExp', 'assetPrice', 'assetTypeName'];
  assetId = 'assetId';
  asset: any;

  constructor(private assetService: AssetService, private router: Router) {}

  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit() {
    this.reloadData();

    this.assetService.getAssetType().subscribe(
      (data) => {
        this.assetType = data;
      },
      (error) => console.log(error)
    );
  }
  reloadData(): void {
    this.assetService.getAssetList().subscribe(
      (list) => {
        console.log('abcsd', list);

        this.assetTable = list;
      },
      (error) => console.log(error)
    );
  }

  searchByName(value: string): void {
    console.log(this.searchByName);

    this.assetReq = {
      ...this.assetReq,
      assetName: value,
    };
    this.assetService.searchNameAsset(this.assetReq).subscribe(
      (search) => {
        this.assetTable = search;
      },
      (error) => console.log(error)
    );
  }

  searchByCode(value: string): void {
    this.assetReq = {
      ...this.assetReq,
      assetCode: value,
    };
    this.assetService.searchCodeAsset(this.assetReq).subscribe(
      (search) => {
        this.assetTable = search;
      },
      (error) => console.log(error)
    );
  }

  assetDelete(value: any) {
    console.log(value);
    if (value.action === 'delete') {
      this.asset = {
        assetId: value.value,
      };
      this.assetService.deleteAsset(this.asset).subscribe(
        (value) => {
          this.reloadData();
        },
        (error) => console.log(error)
      );
    }
  }

  assetDetails(value: any) {
    if (value.action === 'details') {
      this.router.navigate(['detailsAsset', value.value]);
    }
  }

  assetUpdate(value: any) {
    if (value.action === 'update') {
      this.router.navigate(['updateAsset', value.value]);
    }
  }
  link() {
    this.router.navigate(['addAsset']);
  }
}
