import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { AssetType } from '../../Entity/assetType';
import { AssetTypeService } from '../../asset-type.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
//import { FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-update-asset-type',
  templateUrl: './update-asset-type.component.html',
  styleUrls: ['./update-asset-type.component.css'],
})
export class UpdateAssetTypeComponent implements OnInit {
  assetTypeId: number;
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

  onSubmit() {
    console.log('value form', this.assetTypeForm.value);

    this.assetType = {
      assetTypeId: this.assetTypeId,
      assetTypeCode: this.assetTypeForm.value.assetTypeCode,
      assetTypeName: this.assetTypeForm.value.assetTypeName,
    };
    console.log('req', this.assetType);

    this.assetTypeService.updateAssetType(this.assetType).subscribe(
      (data) => {
        console.log(data);

        this.gotoList();
      },
      (error) => console.log(error)
    );
  }
  ngOnInit(): void {
    this.assetTypeId = this.route.snapshot.params.assetTypeId;
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

  gotoList() {
    this.router.navigate(['/assetTypes']);
  }
  list() {
    this.router.navigate(['listAssetTypes']);
  }
}
