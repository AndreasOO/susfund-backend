import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseAssessmentComponent } from './case-assessment.component';

describe('CaseAssessmentComponent', () => {
  let component: CaseAssessmentComponent;
  let fixture: ComponentFixture<CaseAssessmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaseAssessmentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaseAssessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
