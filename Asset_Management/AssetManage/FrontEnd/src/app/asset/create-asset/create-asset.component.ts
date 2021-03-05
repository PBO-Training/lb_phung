import { Component, Input, OnInit } from '@angular/core';
import { AssetService } from '../../service/asset.service';
import { Asset } from '../../Entity/asset';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { AssetType } from 'src/app/Entity/assetType';

@Component({
  selector: 'app-create-asset',
  templateUrl: './create-asset.component.html',
  styleUrls: ['./create-asset.component.css'],
})
export class CreateAssetComponent implements OnInit {
  assetId: number;
  asset: Asset;
  assetTypedrop: AssetType;
  submitted = false;
  assetForm = new FormGroup({
    assetId: new FormControl(),
    assetCode: new FormControl(),
    assetName: new FormControl(),
    assetDayExp: new FormControl(),
    assetPrice: new FormControl(),
    used: new FormControl(),
    doNotUse: new FormControl(),
    assetTypeId: new FormControl(),
  });
  // @Input() fieldName: [];
  constructor(private assetService: AssetService, private router: Router) {}

  ngOnInit(): void {
    this.assetService.getAssetType().subscribe(
      (data) => {
        this.assetTypedrop=data;
      },
      (error) => console.log(error)
    );
  }
  newAsset(): void {
    this.submitted = false;
  }
  onSubmit() {
    console.log('value form', this.assetForm.value);
    // this.asset = {
    //   assetId: this.assetId,
    //   assetCode: this.assetForm.value.assetCode,
    //   assetName: this.assetForm.value.assetName,
    //   assetDayExp: this.assetForm.value.assetDayExp,
    //   assetPrice: this.assetForm.value.assetPrice,
    //   assetTypeId: this.assetForm.value.assetTypeId,
    // };
    this.assetService.createAsset(this.assetForm.value).subscribe(
      (data) => {
        console.log(data);
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }

  gotoList() {
    this.router.navigate(['/listAsset']);
  }
}
