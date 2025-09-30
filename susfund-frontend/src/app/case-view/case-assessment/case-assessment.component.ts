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

  constructor(public router:Router, private fetcher:CasesFetcherService) {

  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getAssessmentFields(this.caseId).subscribe(assessmentFields => {this.assessmentFieldValues = assessmentFields!;});

  }

  public save(fieldValue:any){
    this.fetcher.updateFields(this.caseId, [fieldValue]).subscribe({
      next: () => console.log("saved stuff"),
      error: err => console.error("saved nothing because: ", err)
    });
  }


}
