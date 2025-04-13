import {Component, OnInit} from '@angular/core';
import {Router, ROUTER_OUTLET_DATA} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseAssessmentUtil} from '../../cases-services/case-util/case-assessment-util';
import {AssessmentUpdateRequest} from '../../cases-services/case-util/assessment-update-request';

@Component({
  selector: 'app-case-assessment',
  standalone: false,
  templateUrl: './case-assessment.component.html',
  styleUrl: './case-assessment.component.css'
})
export class CaseAssessmentComponent implements OnInit {

  caseId:string | undefined
  caseAssessmentUtil:CaseAssessmentUtil | undefined

  constructor(public router:Router, private fetcher:CasesFetcherService) {

  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getCaseAssessmentUtilByCaseId(this.caseId).subscribe(caseAssessmentUtil => this.caseAssessmentUtil = caseAssessmentUtil!)
  }

  public saveUpdate(assessmentItemId:number, updatedJustification:string, updatedScore:number){
    const update:AssessmentUpdateRequest ={
      assessmentItemId:assessmentItemId,
      score:updatedScore,
      justification:updatedJustification
    }

    const response = this.fetcher.updateAssessmentItem(this.caseId!, update).subscribe(response =>{
        console.log(response)
      },
      error => console.log(error)
    );

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
