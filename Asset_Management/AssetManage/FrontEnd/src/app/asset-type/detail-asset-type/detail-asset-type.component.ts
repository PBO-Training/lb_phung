import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AssetTypeService } from '../../service/asset-type.service';
import { error } from '@angular/compiler/src/util';
import { AssetType } from 'src/app/Entity/assetType';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-detail-asset-type',
  templateUrl: './detail-asset-type.component.html',
  styleUrls: ['./detail-asset-type.component.css'],
})
export class DetailAssetTypeComponent implements OnInit {
  assetTypeId: any;
  assetType: AssetType;
  assetTypeForm = new FormGroup({

    assetTypeCode: new FormControl(),
    assetTypeName: new FormControl(),
  });

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private assetTypeService: AssetTypeService
  ) {}

  ngOnInit(): void {
    this.assetTypeId = {
     assetTypeId : this.route.snapshot.params.assetTypeId
    };
    this.assetTypeService.getAssetTypeId(this.assetTypeId).subscribe(
      (data) => {
        this.assetTypeForm.patchValue({
          assetTypeCode: data.assetTypeCode,
          assetTypeName: data.assetTypeName,
        });
      },
      (error) => console.log(error)
    );
  }

  list() {
    this.router.navigate(['listAssetTypes']);
  }
}
