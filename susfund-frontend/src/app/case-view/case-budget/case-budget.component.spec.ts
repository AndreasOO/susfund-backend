import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseBudgetComponent } from './case-budget.component';

describe('CaseBudgetComponent', () => {
  let component: CaseBudgetComponent;
  let fixture: ComponentFixture<CaseBudgetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaseBudgetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaseBudgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
