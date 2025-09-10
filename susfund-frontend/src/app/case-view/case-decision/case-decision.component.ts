import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseEntityDto} from '../../cases-services/case-entity/case-entity-dto';
import {DecisionFieldValueDto} from '../../cases-services/case-entity/value/decision-field-value-dto';
import {CaseManagerDto} from '../../cases-services/case-entity/case-manager-dto';

@Component({
  selector: 'app-case-decision',
  standalone: false,
  templateUrl: './case-decision.component.html',
  styleUrl: './case-decision.component.css'
})
export class CaseDecisionComponent implements OnInit{

  errorMessage: string | null = null
  successMessage: string | null = null

  caseId: string | undefined

  caseManagerList:CaseManagerDto[] | undefined
  caseEntity:CaseEntityDto|undefined
  decisionFields:DecisionFieldValueDto[] = []

  constructor(private router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getAllCaseManagers().subscribe(caseManagerList => this.caseManagerList = caseManagerList!)
    this.fetcher.getCaseById(this.caseId).subscribe(caseEntity => this.caseEntity = caseEntity!)
    this.fetcher.getDecisionFieldValue(this.caseId).subscribe(decisionFields => this.decisionFields = decisionFields!)
  }
}
