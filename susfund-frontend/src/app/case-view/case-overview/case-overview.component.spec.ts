import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseOverviewComponent } from './case-overview.component';

describe('GeneralOverviewComponent', () => {
  let component: CaseOverviewComponent;
  let fixture: ComponentFixture<CaseOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaseOverviewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaseOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
