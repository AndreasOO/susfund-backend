import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CaseManager} from '../../cases-services/case-entity/case-manager';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseDecision} from '../../cases-services/case-entity/case-decision';
import {CaseDecisionResult} from '../../cases-services/case-entity/case-decision-result';
import {CaseEntityDto} from '../../cases-services/case-entity/new/case-entity-dto';
import {DecisionFieldValueDto} from '../../cases-services/case-entity/new/field/value/decision-field-value-dto';
import {AssessmentFieldValueDto} from '../../cases-services/case-entity/new/field/value/assessment-field-value-dto';
import {CaseManagerDto} from '../../cases-services/case-entity/new/case-manager-dto';

@Component({
  selector: 'app-case-decision',
  standalone: false,
  templateUrl: './case-decision.component.html',
  styleUrl: './case-decision.component.css'
})
export class CaseDecisionComponent implements OnInit{

  errorMessage: string | null = null
  successMessage: string | null = null

  caseManagerList:CaseManagerDto[] | undefined
  caseEntity:CaseEntityDto|undefined
  decisionFields:DecisionFieldValueDto[] = []

  constructor(private router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.fetcher.getAllCaseManagers().subscribe(caseManagerList => this.caseManagerList = caseManagerList!)
    this.fetcher.getCaseEntity().subscribe(caseEntity => this.caseEntity = caseEntity!)
    this.fetcher.getDecisionFieldValue().subscribe(decisionFields => this.decisionFields = decisionFields!)
  }
}
