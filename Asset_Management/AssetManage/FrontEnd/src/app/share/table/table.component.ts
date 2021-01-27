import { Component, Input, OnInit } from '@angular/core';
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
  @Input 
  constructor(
   
  ) {}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  // tslint:disable-next-line: typedef
  
}
