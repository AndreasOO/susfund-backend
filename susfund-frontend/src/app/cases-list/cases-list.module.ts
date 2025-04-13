import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyCasesListComponent } from './my-cases-list/my-cases-list.component';
import {RouterLink} from '@angular/router';



@NgModule({
  declarations: [
    MyCasesListComponent
  ],
  imports: [
    CommonModule,
    RouterLink
  ]
})
export class CasesListModule { }
