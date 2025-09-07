import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {HistoryEvent} from '../../cases-services/case-entity/history-event';
import {HistoryLogFieldValueDto} from '../../cases-services/case-entity/new/field/value/history-log-field-value-dto';

@Component({
  selector: 'app-case-history',
  standalone: false,
  templateUrl: './case-history.component.html',
  styleUrl: './case-history.component.css'
})
export class CaseHistoryComponent implements OnInit {

  caseId: string | undefined
  // historyEventList: HistoryEvent[] | undefined

  historyLogFields:HistoryLogFieldValueDto[] = []

  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    // this.fetcher.getHistoryEventByCaseId(this.caseId).subscribe(historyEventList => this.historyEventList = historyEventList!)

    this.fetcher.getHistoryFieldValue(this.caseId).subscribe(historyFields => this.historyLogFields = historyFields!)
  }
}
