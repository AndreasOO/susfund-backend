import { Component } from '@angular/core';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseLazy} from '../../cases-services/case-entity/case-lazy';
import {OnInit} from '@angular/core';

@Component({
  selector: 'app-my-cases-list',
  standalone: false,
  templateUrl: './my-cases-list.component.html',
  styleUrl: './my-cases-list.component.css'
})
export class MyCasesListComponent implements OnInit {
  caseList:CaseLazy[] | undefined

  constructor(private fetcher:CasesFetcherService) {

  }

  ngOnInit() {
    this.fetcher.getAllCases().subscribe(caseList => this.caseList = caseList)
  }
}
