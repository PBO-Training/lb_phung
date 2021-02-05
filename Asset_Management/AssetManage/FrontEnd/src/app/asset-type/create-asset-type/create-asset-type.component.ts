import { Component, OnInit } from '@angular/core';
import { AssetTypeService } from '../../service/asset-type.service';
import { AssetType } from '../../Entity/assetType';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-create-asset-type',
  templateUrl: './create-asset-type.component.html',
  styleUrls: ['./create-asset-type.component.css'],
})
export class CreateAssetTypeComponent implements OnInit {
   assetTypeId: number;
  assetType: AssetType;
  submitted = false;
  assetTypeForm = new FormGroup({
    assetTypeCode: new FormControl(),
    assetTypeName: new FormControl(),
  });

  constructor(
    private assetTypeService: AssetTypeService,
    private router: Router
  ) {}

  ngOnInit(): void {}
  newAssetType(): void {
    this.submitted = false;
  }
  onSubmit() {
    console.log('value form', this.assetTypeForm.value);
    this.assetType = {
      assetTypeId: this.assetTypeId,
      assetTypeCode: this.assetTypeForm.value.assetTypeCode,
      assetTypeName: this.assetTypeForm.value.assetTypeName,
    };
    this.assetTypeService.createAssetType(this.assetType).subscribe(
      (data) => {
        console.log(data);
        this.gotoList();
      },
      (error) => console.log(error)
    );}

  gotoList() {
    this.router.navigate(['/listAssetTypes']);
  }
}
