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

  simpleCaseList:SimpleCaseDto[] = []

  constructor(private fetcher:CasesFetcherService) {

  }

  ngOnInit() {

    this.fetcher.getAllCaseEntities().subscribe(simpleCaseList => this.simpleCaseList = simpleCaseList!)
  }

}
