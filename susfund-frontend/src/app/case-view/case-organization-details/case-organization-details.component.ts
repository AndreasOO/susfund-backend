import {Component, inject, Signal, OnInit} from '@angular/core';
import {Router, ROUTER_OUTLET_DATA} from '@angular/router';
import {CaseDetails} from '../../cases-services/case-entity/case-details';
import {Organization} from '../../cases-services/case-entity/organization';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseLazy} from '../../cases-services/case-entity/case-lazy';
import {async, flatMap, mergeMap} from 'rxjs';

@Component({
  selector: 'app-case-organization-details',
  standalone: false,
  templateUrl: './case-organization-details.component.html',
  styleUrl: './case-organization-details.component.css'
})
export class CaseOrganizationDetailsComponent implements OnInit{
  caseId: string | undefined
  caseOrganization:Organization | undefined
  casesRelatedToOrganization:CaseLazy[] | undefined

  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getOrganizationByCaseId(this.caseId).subscribe(caseOrganization => this.caseOrganization = caseOrganization!)
    this.fetcher.getCasesLazyByCaseOrganization(this.caseId).subscribe(caseList => this.casesRelatedToOrganization = caseList!)
  }
}
