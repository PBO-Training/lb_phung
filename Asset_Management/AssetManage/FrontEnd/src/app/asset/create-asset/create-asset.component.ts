import { Component, OnInit } from '@angular/core';
import { AssetService } from '../../service/asset.service';
import { Asset } from '../../Entity/asset';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-create-asset',
  templateUrl: './create-asset.component.html',
  styleUrls: ['./create-asset.component.css'],
})
export class CreateAssetComponent implements OnInit {
   assetId: number;
  asset: Asset;
  submitted = false;
  assetForm = new FormGroup({
    assetCode: new FormControl(),
    assetName: new FormControl(),
    assetDayExp: new FormControl(),
    assetPrice: new FormControl(),
    assetTypeId: new FormControl(),
  });

  constructor(
    private assetService: AssetService,
    private router: Router
  ) {}

  ngOnInit(): void {}
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
    );}

  gotoList() {
    this.router.navigate(['/listAsset']);
  }
}
