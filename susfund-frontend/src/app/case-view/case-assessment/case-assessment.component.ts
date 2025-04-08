import {Component, OnInit} from '@angular/core';
import {Router, ROUTER_OUTLET_DATA} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseAssessmentUtil} from '../../cases-services/case-util/case-assessment-util';

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
}
