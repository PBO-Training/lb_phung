import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColSpanPropertyComponent } from './col-span-property.component';

describe('ColSpanPropertyComponent', () => {
  let component: ColSpanPropertyComponent;
  let fixture: ComponentFixture<ColSpanPropertyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColSpanPropertyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColSpanPropertyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
