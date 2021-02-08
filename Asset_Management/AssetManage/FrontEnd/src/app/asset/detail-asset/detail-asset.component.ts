import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AssetService } from '../../service/asset.service';
import { error } from '@angular/compiler/src/util';
import { Asset } from 'src/app/Entity/asset';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-detail-asset',
  templateUrl: './detail-asset.component.html',
  styleUrls: ['./detail-asset.component.css'],
})
export class DetailAssetComponent implements OnInit {
  assetId: any;
  asset: Asset;
  assetForm = new FormGroup({
    assetCode: new FormControl(),
    assetName: new FormControl(),
    assetDayExp: new FormControl(),
    assetPrice: new FormControl(),
  });

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private assetService: AssetService
  ) {}

  ngOnInit(): void {
    this.assetId = {
      assetId: this.route.snapshot.params.assetId,
    };
    this.assetService.getAssetId(this.assetId).subscribe(
      (data) => {
        this.assetForm.patchValue({
          assetCode: data.assetCode,
          assetName: data.assetName,
          assetDayExp: data.assetDayExp,
          assetPrice: data.assetPrice,
        });
      },
      (error) => console.log(error)
    );
  }

  list() {
    this.router.navigate(['listAsset']);
  }
}
