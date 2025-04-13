import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CaseOverviewComponent } from './case-overview/case-overview.component';
import { CaseSidebarMenuComponent } from './case-sidebar-menu/case-sidebar-menu.component';
import { CaseMainViewComponent } from './case-main-view/case-main-view.component';
import {CaseViewRoutingModule} from './case-view-routing.module';
import { CaseOrganizationDetailsComponent } from './case-organization-details/case-organization-details.component';
import { CaseApplicationComponent } from './case-application/case-application.component';
import { CaseBudgetComponent } from './case-budget/case-budget.component';
import { CaseAssessmentComponent } from './case-assessment/case-assessment.component';
import { CaseDecisionComponent } from './case-decision/case-decision.component';
import { CaseHistoryComponent } from './case-history/case-history.component';
import { CaseDocumentsComponent } from './case-documents/case-documents.component';


@NgModule({
  declarations: [
    CaseOverviewComponent,
    CaseSidebarMenuComponent,
    CaseMainViewComponent,
    CaseOrganizationDetailsComponent,
    CaseApplicationComponent,
    CaseBudgetComponent,
    CaseAssessmentComponent,
    CaseDecisionComponent,
    CaseHistoryComponent,
    CaseDocumentsComponent
  ],
  exports: [
    CaseOverviewComponent
  ],
  imports: [
    CommonModule,
    CaseViewRoutingModule
  ]
})
export class CaseViewModule { }
