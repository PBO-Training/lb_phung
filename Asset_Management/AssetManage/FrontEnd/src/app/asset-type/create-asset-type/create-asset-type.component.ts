import { Component, OnInit } from '@angular/core';
import { AssetTypeService } from '../../asset-type.service';
import { AssetType } from '../../Entity/assetType';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-asset-type',
  templateUrl: './create-asset-type.component.html',
  styleUrls: ['./create-asset-type.component.css'],
})
export class CreateAssetTypeComponent implements OnInit {
  assetType: AssetType;
  submitted = false;

  constructor(
    private assetTypeService: AssetTypeService,
    private router: Router
  ) {}

  ngOnInit(): void {}
  newAssetType(): void {
    this.submitted = false;
  }
  save() {
    this.assetTypeService.createAssetType(this.assetType).subscribe(
      (data) => {
        console.log(data);

        this.gotoList();
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/listAssetTypes']);
  }
} //end
