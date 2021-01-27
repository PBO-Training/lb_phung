import { Component, OnInit } from '@angular/core';
import { AssetType } from '../../Entity/assetType';
import { AssetTypeService } from '../../asset-type.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-asset-type',
  templateUrl: './update-asset-type.component.html',
  styleUrls: ['./update-asset-type.component.css'],
})
export class UpdateAssetTypeComponent implements OnInit {
  assetTypeId: number;
  assetType: AssetType;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private assetTypeService: AssetTypeService
  ) {}

  ngOnInit() {
    this.assetTypeId = this.route.snapshot.params['assetTypeId'];

    this.assetTypeService.getAssetType(this.assetTypeId).subscribe(
      (data) => {
        console.log(data);
        this.assetType = data;
      },
      (error) => console.log(error)
    );
  }

  updateAssetType() {
    this.assetTypeService
      .updateAssetType(this.assetTypeId, this.assetType)
      .subscribe(
        (data) => {
          console.log(data);

          this.gotoList();
        },
        (error) => console.log(error)
      );
  }

  onSubmit() {
    this.updateAssetType();
  }

  gotoList() {
    this.router.navigate(['/assetTypes']);
  }
  list() {
    this.router.navigate(['assetTypes']);
  }
}
