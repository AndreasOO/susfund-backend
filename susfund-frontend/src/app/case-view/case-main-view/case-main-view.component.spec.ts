import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseMainViewComponent } from './case-main-view.component';

describe('CaseMainViewComponent', () => {
  let component: CaseMainViewComponent;
  let fixture: ComponentFixture<CaseMainViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaseMainViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaseMainViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
