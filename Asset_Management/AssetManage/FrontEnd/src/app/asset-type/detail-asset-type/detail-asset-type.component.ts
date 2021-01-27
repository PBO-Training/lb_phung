import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AssetTypeService } from '../../asset-type.service';
import { error } from '@angular/compiler/src/util';
import { AssetType } from 'src/app/Entity/assetType';
@Component({
  selector: 'app-detail-asset-type',
  templateUrl: './detail-asset-type.component.html',
  styleUrls: ['./detail-asset-type.component.css'],
})
export class DetailAssetTypeComponent implements OnInit {
  assetTypeId: number;
  assetType: AssetType;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private assetTypeService: AssetTypeService
  ) {}

  ngOnInit(): void {
    
    this.assetTypeId = this.route.snapshot.params['assetTypeId'];
    this.assetTypeService.getAssetType(this.assetTypeId).subscribe(
      (data) => {
        console.log(data);
        this.assetType = data;
      },
      (error) => console.log(error)
    );
  }
  list() {
    this.router.navigate(['listAssetTypes']);
  }
}
