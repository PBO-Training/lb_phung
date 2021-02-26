import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAssetTypeComponent } from './update-asset-type.component';

describe('UpdateAssetTypeComponent', () => {
  let component: UpdateAssetTypeComponent;
  let fixture: ComponentFixture<UpdateAssetTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateAssetTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateAssetTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
