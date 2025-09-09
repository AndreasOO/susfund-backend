import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {BudgetFieldValueDto} from '../../cases-services/case-entity/value/budget-field-value-dto';

@Component({
  selector: 'app-case-budget',
  standalone: false,
  templateUrl: './case-budget.component.html',
  styleUrl: './case-budget.component.css'
})
export class CaseBudgetComponent implements OnInit{

  caseId : string | undefined
  budgetFields:BudgetFieldValueDto[] = []

  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getBudgetFieldValue(this.caseId).subscribe(fields => this.budgetFields = fields)
  }
}
