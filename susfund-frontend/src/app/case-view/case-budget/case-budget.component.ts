import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseBudget} from '../../cases-services/case-entity/case-budget';
import {Financing} from '../../cases-services/case-entity/financing';

@Component({
  selector: 'app-case-budget',
  standalone: false,
  templateUrl: './case-budget.component.html',
  styleUrl: './case-budget.component.css'
})
export class CaseBudgetComponent implements OnInit{

  caseId : string | undefined
  caseBudget : CaseBudget | undefined
  financing: Financing[] | undefined

  errorMessage: string | null = null
  successMessage: string | null = null

  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getBudgetByCaseId(this.caseId).subscribe(caseBudget => {
      this.caseBudget = caseBudget!
      this.financing = caseBudget.financing
    })
  }

  getTotal(): number {
    return this.caseBudget?.budgetPosts.map(post => post.estimatedCost).reduce((a, b) => a + b, 0) ?? 0;
  }

  // updateSEK(percentage: number): number {
  //   return Math.round(this.getTotal() * (percentage / 100))
  // }

  saveFinancing() {

    alert("SAVE CALLED")
    console.log("save financing called")

    const payload = {
      financing: this.financing,
    }

    this.fetcher.updateFinancingByCaseId(this.caseId!, payload).subscribe({
      next: response => {
        // this.successMessage = response.message;
        // this.errorMessage = null
        console.log(response.message)
      },
      error: err => {
        // this.errorMessage = err.error?.error
        // this.successMessage = null
        console.log(err.error?.error)
      }
    })

    this.fetcher.updateCaseBudgetWithFinancingUpdate(this.caseId!, this.caseBudget!).subscribe({
      next: response => {
        this.successMessage = response.message;
        this.errorMessage = null;
      },
      error: err => {
        this.errorMessage = err.error?.error ?? 'Unexpected error';
        this.successMessage = null;
      }
    })

  }

  percentageChange(newPercentage: number, finance: Financing){
    finance.estimatedFinancingInPercentage = newPercentage;
    finance.estimatedFinancingInMoney = Math.round((newPercentage / 100) * this.getTotal());
  }



}
