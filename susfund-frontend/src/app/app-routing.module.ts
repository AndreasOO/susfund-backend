import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CaseOverviewComponent} from './case-view/case-overview/case-overview.component';
import {MyCasesListComponent} from './cases-list/my-cases-list/my-cases-list.component';
import {CaseMainViewComponent} from './case-view/case-main-view/case-main-view.component';

const routes: Routes = [
  {path: 'cases', component: MyCasesListComponent},
  {path: '', component: MyCasesListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
