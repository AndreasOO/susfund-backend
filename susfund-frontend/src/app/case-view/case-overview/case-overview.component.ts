import {Component, OnInit} from '@angular/core';
import {CaseDetails} from '../../cases-services/case-entity/case-details';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseManager} from '../../cases-services/case-entity/case-manager';
import {CaseBudget} from '../../cases-services/case-entity/case-budget';



@Component({
  selector: 'app-case-overview',
  standalone: false,
  templateUrl: './case-overview.component.html',
  styleUrl: './case-overview.component.css'
})
export class CaseOverviewComponent implements OnInit{

  caseId:string | undefined
  currentCaseManager:CaseManager | undefined
  caseManagerList:CaseManager[] | undefined
  caseDetails:CaseDetails | undefined
  caseBudget : CaseBudget | undefined

  constructor(public router:Router, private fetcher:CasesFetcherService) {

  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getCaseById(this.caseId).subscribe(caseDetails => this.caseDetails = caseDetails!)
    this.fetcher.getCaseManagerByCaseId(this.caseId).subscribe(caseManager => this.currentCaseManager = caseManager!)
    this.fetcher.getAllCaseManagers().subscribe(caseManagerList => this.caseManagerList = caseManagerList!)
    this.fetcher.getBudgetByCaseId(this.caseId).subscribe(caseBudget => this.caseBudget = caseBudget!)
  }

  getTotalBudget(): number {
    return this.caseBudget?.budgetPosts.map(post => post.estimatedCost).reduce((a, b) => a + b, 0) ?? 0;
  }
}
