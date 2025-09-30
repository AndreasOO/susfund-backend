import {Component, inject, Signal} from '@angular/core';
import {Router, ROUTER_OUTLET_DATA} from '@angular/router';
import {OnInit} from '@angular/core';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {TextFieldValueDto} from '../../cases-services/case-entity/value/text-field-value-dto';

@Component({
  selector: 'app-case-application',
  standalone: false,
  templateUrl: './case-application.component.html',
  styleUrl: './case-application.component.css'
})
export class CaseApplicationComponent implements OnInit {

  caseId : string | undefined
  public textFieldValues:TextFieldValueDto[] = []

  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {

    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getApplicationFields(this.caseId).subscribe(textFields => {this.textFieldValues = textFields!;});

  }

  public save(textFieldValue: any){
    this.fetcher.updateFields(this.caseId, [textFieldValue]).subscribe({
      next: () => console.log("saved stuff"),
      error: err => console.error("saved nothing because: ", err)
    });
  }
}
