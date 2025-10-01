import {Component, OnInit} from '@angular/core';
import {Router, ROUTER_OUTLET_DATA} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {AssessmentFieldValueDto} from '../../cases-services/case-entity/value/assessment-field-value-dto';

@Component({
  selector: 'app-case-assessment',
  standalone: false,
  templateUrl: './case-assessment.component.html',
  styleUrl: './case-assessment.component.css'
})
export class CaseAssessmentComponent implements OnInit {

  caseId : string | undefined
  assessmentFieldValues:AssessmentFieldValueDto[] = [];

  fieldStatus: { [id: string]: { message: string, success: boolean } } = {};

  constructor(public router:Router, private fetcher:CasesFetcherService) {

  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getAssessmentFields(this.caseId).subscribe(assessmentFields => {this.assessmentFieldValues = assessmentFields!;});

  }

  public save(fieldValue:any){
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
