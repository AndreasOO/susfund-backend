import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseDecisionComponent } from './case-decision.component';

describe('CaseDecisionComponent', () => {
  let component: CaseDecisionComponent;
  let fixture: ComponentFixture<CaseDecisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaseDecisionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaseDecisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
