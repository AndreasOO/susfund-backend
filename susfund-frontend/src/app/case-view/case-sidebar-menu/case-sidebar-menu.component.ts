import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseStatus} from '../../cases-services/case-entity/case-status';
import {CaseDecisionType} from '../../cases-services/case-entity/case-decision-type';

@Component({
  selector: 'app-case-sidebar-menu',
  standalone: false,
  templateUrl: './case-sidebar-menu.component.html',
  styleUrl: './case-sidebar-menu.component.css'
})



export class CaseSidebarMenuComponent implements OnInit{
  caseId:string | undefined
  caseStatus:CaseStatus | undefined
  caseDecisionType:CaseDecisionType | undefined

  constructor(public router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getCaseStatusByCaseId(this.caseId).subscribe(caseStatus => this.caseStatus = caseStatus!)
    this.fetcher.getCaseDecisionTypeByCaseId(this.caseId).subscribe(caseDecisionType => this.caseDecisionType = caseDecisionType!)
  }

}
