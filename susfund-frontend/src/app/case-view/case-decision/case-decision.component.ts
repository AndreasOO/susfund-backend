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
  caseId:string | undefined
  currentDecision:CaseDecision | undefined
  decisionOptions:CaseDecisionResult[] | undefined

  currentCaseController:CaseManager | undefined
  currentJustification:string | undefined
  selectedDecisionResultId:number| undefined
  selectedCaseControllerId:number | undefined

  errorMessage: string | null = null
  successMessage: string | null = null

  constructor(private router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.fetcher.getAllCaseManagers().subscribe(caseManagerList => this.caseManagerList = caseManagerList!)
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];

    this.fetcher.getCaseControllerByCaseId(this.caseId).subscribe(caseController => {
      this.currentCaseController = caseController!;
      this.selectedCaseControllerId = caseController?.id;
    })

    this.fetcher.getCaseDecisionByCaseId(this.caseId).subscribe(currentDecision => {
      this.currentDecision = currentDecision!;
      this.selectedDecisionResultId = currentDecision?.caseDecisionResult?.id;
      this.currentJustification = currentDecision?.justification;
    })

    this.fetcher.getAllCaseDecisionResultOptions().subscribe(decisionOptions => this.decisionOptions = decisionOptions!)
  }

  saveCaseDecision(){
    const payload = {
      caseControllerId: this.selectedCaseControllerId,
      caseDecisionResultId: this.selectedDecisionResultId,
      justification: this.currentJustification
    }

    this.fetcher.updateCaseDecision(this.caseId!, payload).subscribe({
      next: response => {
        this.successMessage = response.message;
        this.errorMessage = null
      },
      error: err => {
        this.errorMessage = err.error?.error
        this.successMessage = null
      }
    })
  }
}
