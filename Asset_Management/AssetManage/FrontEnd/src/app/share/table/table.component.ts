import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
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
  @Input() assetTypes: AssetType[];
  @Input() searchTypeItem: any;
  searchText;
  @Output() assetTypeDelete = new EventEmitter<number>();
  @Output() assetTypeDetail = new EventEmitter<number>();
  @Output() assetTypeUpdates = new EventEmitter<number>();
  constructor() {}
  ngOnInit(): void {}
  deleteAssetType(value: number) {
    this.assetTypeDelete.emit(value);
  }
  detailAssetType(value: number) {
    this.assetTypeDetail.emit(value);
  }
  updateAssetType(value: number) {
    this.assetTypeUpdates.emit(value);
  }
}
