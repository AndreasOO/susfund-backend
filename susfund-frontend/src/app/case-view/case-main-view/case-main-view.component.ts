import { Component } from '@angular/core';
import { Router} from '@angular/router';
import {OnInit} from '@angular/core';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseEntityDto} from '../../cases-services/case-entity/case-entity-dto';


@Component({
  selector: 'app-case-main-view',
  standalone: false,
  templateUrl: './case-main-view.component.html',
  styleUrl: './case-main-view.component.css'
})
export class CaseMainViewComponent implements OnInit {

  caseId:string | undefined
  caseEntity:CaseEntityDto | undefined

  constructor(public router:Router, private fetcher:CasesFetcherService) {

    }

    ngOnInit() {
      this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
      this.fetcher.getCaseById(this.caseId).subscribe(caseEntity => this.caseEntity = caseEntity!)
    }
}
