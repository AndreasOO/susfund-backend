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
  caseId: string | undefined
  caseManagerList:CaseManagerDto[] | undefined
  caseEntity:CaseEntityDto|undefined
  decisionFields:DecisionFieldValueDto[] = []

  fieldStatus: { [id: string]: { message: string, success: boolean } } = {};

  constructor(private router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getAllCaseManagers().subscribe(caseManagerList => this.caseManagerList = caseManagerList!)
    this.fetcher.getCaseById(this.caseId).subscribe(caseEntity => this.caseEntity = caseEntity!)
    this.fetcher.getDecisionFieldValue(this.caseId).subscribe(decisionFields => this.decisionFields = decisionFields!)
  }


  public save(fieldValue: any){
    this.fetcher.updateFields(this.caseId, [fieldValue]).subscribe({
      next: (response: Response) => {
        this.fieldStatus[fieldValue.id] = { message: "Update successfully saved", success: true };
        console.log("saved stuff")
      },
      error: err => {
        this.fieldStatus[fieldValue.id] = { message: "Something went wrong", success: false };
        console.error("saved nothing because: ", err)
      }
    });
  }
}
