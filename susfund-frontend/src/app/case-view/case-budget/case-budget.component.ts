import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseBudget} from '../../cases-services/case-entity/case-budget';

@Component({
  selector: 'app-case-budget',
  standalone: false,
  templateUrl: './case-budget.component.html',
  styleUrl: './case-budget.component.css'
})
export class CaseBudgetComponent implements OnInit{

  caseId : string | undefined
  caseBudget : CaseBudget | undefined

  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getBudgetByCaseId(this.caseId).subscribe(caseBudget => this.caseBudget = caseBudget!)
  }

  getTotal(): number {
    return this.caseBudget?.budgetPosts.map(post => post.estimatedCost).reduce((a, b) => a + b, 0) ?? 0;
  }

}
