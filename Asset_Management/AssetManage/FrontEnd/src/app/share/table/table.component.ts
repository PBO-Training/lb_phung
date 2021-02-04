import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
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
export class TableComponent implements OnInit, OnChanges {
  @Input() data: any[];
  @Input() columnTitle: any[];
  @Input() fieldName: any[];
  @Input() Id: any;
  @Input() hidden: boolean;
  @Output() delete = new EventEmitter<number>();
  @Output() detail = new EventEmitter<number>();
  @Output() updates = new EventEmitter<number>();

  constructor() {}

  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.data);
  }
  ngOnInit(): void {}

  deleteRecord(value: number): void {
    this.delete.emit(value);
  }
  detailRecord(value: number): void {
    this.detail.emit(value);
  }
  updatesRecord(value: number): void {
    this.updates.emit(value);
  }
}
