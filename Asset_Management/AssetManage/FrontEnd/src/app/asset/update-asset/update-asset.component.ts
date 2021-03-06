import { Component, OnInit} from '@angular/core';
import { Asset } from '../../Entity/asset';
import { AssetService } from '../../service/asset.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { AssetType } from 'src/app/Entity/assetType';
//import { FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-update-asset',
  templateUrl: './update-asset.component.html',
  styleUrls: ['./update-asset.component.css'],
})
export class UpdateAssetComponent implements OnInit {
  assetId: any;
  asset: Asset;
  assetTypedrop: AssetType;
  assetForm = new FormGroup({
    assetId: new FormControl(),
    assetCode: new FormControl(),
    assetName: new FormControl(),
    assetDayExp: new FormControl(),
    assetPrice: new FormControl(),
    assetTypeId: new FormControl(),
    assetTypeName: new FormControl(),
  });
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private assetService: AssetService
  ) {}

  onSubmit() {
    console.log('value form', this.assetForm.value);
    this.asset = {
      assetId: this.route.snapshot.params.assetId,
      assetCode: this.assetForm.value.assetCode,
      assetName: this.assetForm.value.assetName,
      assetDayExp: this.assetForm.value.assetDayExp,
      assetPrice: this.assetForm.value.assetPrice,
      used: this.assetForm.value.used,
      doNotUse: this.assetForm.value.doNotUse,
      assetType: {
        assetTypeId: this.assetForm.value.assetTypeId,
      },
    };
    this.assetService.updateAsset(this.asset).subscribe(
      (data) => {
        console.log(data);
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }
  ngOnInit(): void {
    this.assetId = {
      assetId: this.route.snapshot.params.assetId,
    };
    this.assetService.getAssetId(this.assetId).subscribe(
      (data) => {
        console.log(data);

        this.assetForm.patchValue({
          assetId: data.assetId,
          assetCode: data.assetCode,
          assetName: data.assetName,
          assetDayExp: data.assetDayExp,
          assetPrice: data.assetPrice,
          assetTypeId: data.assetTypeMap.assetTypeId,
        });
      },
      (error) => console.log(error)
    );
      this.assetService.getAssetType().subscribe(
        (data) => {
          this.assetTypedrop = data;
        },
        (error) => console.log(error)
      );
  }
  gotoList() {
    this.router.navigate(['/listAsset']);
  }
}
