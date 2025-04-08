import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CaseOverviewComponent} from '../case-view/case-overview/case-overview.component';
import {CaseMainViewComponent} from '../case-view/case-main-view/case-main-view.component';
import {CaseOrganizationDetailsComponent} from './case-organization-details/case-organization-details.component';
import {CaseApplicationComponent} from './case-application/case-application.component';
import {CaseBudgetComponent} from './case-budget/case-budget.component';
import {CaseAssessmentComponent} from './case-assessment/case-assessment.component';
import {CaseDecisionComponent} from './case-decision/case-decision.component';
import {CaseHistoryComponent} from './case-history/case-history.component';
import {CaseDocumentsComponent} from './case-documents/case-documents.component';

const routes: Routes = [
  {path: 'cases/:id',
    component: CaseMainViewComponent,
  children: [
    { path: 'overview', component: CaseOverviewComponent},
    { path: 'organization', component: CaseOrganizationDetailsComponent},
    { path: 'budget', component: CaseBudgetComponent},
    { path: 'application', component: CaseApplicationComponent},
    { path: 'assessment', component: CaseAssessmentComponent},
    { path: 'decision', component: CaseDecisionComponent},
    { path: 'history', component: CaseHistoryComponent},
    { path: 'documents', component: CaseDocumentsComponent},
    { path: '', component: CaseOverviewComponent}
  ]},
];



@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CaseViewRoutingModule { }
