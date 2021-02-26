import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoWayBinDingComponent } from './two-way-bin-ding.component';

describe('TwoWayBinDingComponent', () => {
  let component: TwoWayBinDingComponent;
  let fixture: ComponentFixture<TwoWayBinDingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwoWayBinDingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwoWayBinDingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
