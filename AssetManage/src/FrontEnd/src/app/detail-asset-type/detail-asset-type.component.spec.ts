import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailAssetTypeComponent } from './detail-asset-type.component';

describe('DetailAssetTypeComponent', () => {
  let component: DetailAssetTypeComponent;
  let fixture: ComponentFixture<DetailAssetTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailAssetTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailAssetTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
