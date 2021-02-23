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
@Component({
  selector: 'app-list-asset',
  templateUrl: './list-asset.component.html',
  styleUrls: ['./list-asset.component.css'],
})
export class ListAssetComponent implements OnInit, OnChanges {
  assetTable: Asset[];
  assetReq: Asset;
  columnTables = ['Code', 'Name', 'DayExp', 'Price','Used','Do Not Use'];
  fieldName = ['assetCode', 'assetName', 'assetDayExp', 'assetPrice','used','doNotUse'];
  assetId = 'assetId';
  asset: any;

  constructor(
    private assetService: AssetService,
    private router: Router
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit() {
    this.reloadData();
  }
  reloadData(): void {
    this.assetService.getAssetList().subscribe(
      (list) => {
        console.log(list);

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
