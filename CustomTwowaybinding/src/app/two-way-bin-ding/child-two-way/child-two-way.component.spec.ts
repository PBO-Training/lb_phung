import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildTwoWayComponent } from './child-two-way.component';

describe('ChildTwoWayComponent', () => {
  let component: ChildTwoWayComponent;
  let fixture: ComponentFixture<ChildTwoWayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChildTwoWayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildTwoWayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
