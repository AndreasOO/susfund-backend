import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseSidebarMenuComponent } from './case-sidebar-menu.component';

describe('CaseSidebarMenuComponent', () => {
  let component: CaseSidebarMenuComponent;
  let fixture: ComponentFixture<CaseSidebarMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaseSidebarMenuComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaseSidebarMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
