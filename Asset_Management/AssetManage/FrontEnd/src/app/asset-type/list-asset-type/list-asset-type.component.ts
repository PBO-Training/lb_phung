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
  assetTypes: AssetType[];
  assetTypeReq: AssetType;

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
    //this.SearchType();
  }

  reloadData(): void {
    this.assetTypeService.getAssetTypesList().subscribe(
      (list) => {
        this.assetTypes = list;
      },
      (error) => console.log(error)
    );
  }

  searchByName(value: string): void {
    this.assetTypeReq = {
      ...this.assetTypeReq,
      assetTypeName: value,
    };
    this.assetTypeService.searchFollowCondition(this.assetTypeReq).subscribe(
      (search) => {
        this.assetTypes = search;
      },
      (error) => console.log(error)
    );
  }

  deleteAssetType(assetTypeid: number) {
    this.assetTypeService.deleteAssetType(assetTypeid).subscribe(
      (data) => {
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
