import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CaseManager} from '../../cases-services/case-entity/case-manager';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseDecision} from '../../cases-services/case-entity/case-decision';
import {CaseDecisionResult} from '../../cases-services/case-entity/case-decision-result';

@Component({
  selector: 'app-case-decision',
  standalone: false,
  templateUrl: './case-decision.component.html',
  styleUrl: './case-decision.component.css'
})
export class CaseDecisionComponent implements OnInit{
  caseManagerList:CaseManager[] | undefined
  currentCaseManager:CaseManager | undefined
  caseId:string | undefined
  currentDecision:CaseDecision | undefined
  decisionOptions:CaseDecisionResult[] | undefined

  constructor(private router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.fetcher.getAllCaseManagers().subscribe(caseManagerList => this.caseManagerList = caseManagerList!)
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getCaseManagerByCaseId(this.caseId).subscribe(caseManager => this.currentCaseManager = caseManager!)
    this.fetcher.getCaseDecisionByCaseId(this.caseId).subscribe(currentDecision => this.currentDecision = currentDecision!)
    this.fetcher.getAllCaseDecisionResultOptions().subscribe(decisionOptions => this.decisionOptions = decisionOptions!)
  }
}
