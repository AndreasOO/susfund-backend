import { Component } from '@angular/core';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {OnInit} from '@angular/core';
import {SimpleCaseDto} from '../../cases-services/case-entity/simple-case-dto';

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
