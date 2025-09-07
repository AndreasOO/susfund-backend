import { Component } from '@angular/core';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseLazy} from '../../cases-services/case-entity/case-lazy';
import {OnInit} from '@angular/core';
import {SimpleCaseDto} from '../../cases-services/case-entity/new/simple-case-dto';
import {CaseEntityDto} from '../../cases-services/case-entity/new/case-entity-dto';

@Component({
  selector: 'app-my-cases-list',
  standalone: false,
  templateUrl: './my-cases-list.component.html',
  styleUrl: './my-cases-list.component.css'
})
export class MyCasesListComponent implements OnInit {
  // caseList:CaseLazy[] | undefined

  simpleCase:SimpleCaseDto | undefined

  caseList:CaseEntityDto[] = []

  constructor(private fetcher:CasesFetcherService) {

  }

  // ngOnInit() {
  //   this.fetcher.getAllCases().subscribe(caseList => this.caseList = caseList)
  // }

  // tillfällig
  ngOnInit() {
    this.fetcher.getTheOneAndOnlyCase().subscribe(simpleCase => this.simpleCase = simpleCase)

    this.fetcher.getAllCaseEntities().subscribe(caseList => this.caseList = caseList!)
  }

}
