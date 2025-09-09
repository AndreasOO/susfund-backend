import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseEntityDto} from '../../cases-services/case-entity/case-entity-dto';

@Component({
  selector: 'app-case-sidebar-menu',
  standalone: false,
  templateUrl: './case-sidebar-menu.component.html',
  styleUrl: './case-sidebar-menu.component.css'
})

export class CaseSidebarMenuComponent implements OnInit{

  caseId:string | undefined
  caseEntity:CaseEntityDto|undefined

  constructor(public router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getCaseById(this.caseId).subscribe(caseEntity => this.caseEntity = caseEntity!)
  }

}
