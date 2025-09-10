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

  public getSelectedScore(groupName:number){

    const radioButton = document.querySelector(`input[name="${groupName}"]:checked`) as HTMLInputElement;

    switch(radioButton.value){
      case "option1": return 1
      case "option2": return 2
      case "option3": return 3
      case "option4": return 4
      case "option5": return 5
      default: return 0
    }
  }

}
