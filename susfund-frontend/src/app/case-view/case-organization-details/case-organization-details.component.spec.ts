import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseOrganizationDetailsComponent } from './case-organization-details.component';

describe('CaseOrganizationDetailsComponent', () => {
  let component: CaseOrganizationDetailsComponent;
  let fixture: ComponentFixture<CaseOrganizationDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaseOrganizationDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaseOrganizationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
