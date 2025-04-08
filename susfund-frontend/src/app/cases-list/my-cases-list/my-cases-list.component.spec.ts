import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyCasesListComponent } from './my-cases-list.component';

describe('MyCasesListComponent', () => {
  let component: MyCasesListComponent;
  let fixture: ComponentFixture<MyCasesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyCasesListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyCasesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
