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
  textFieldValues:TextFieldValueDto[] = []

  fieldStatus: { [id: string]: { message: string, success: boolean } } = {};

  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {

    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getApplicationFields(this.caseId).subscribe(textFields => {this.textFieldValues = textFields!;});

  }

  public save(fieldValue: any){
    this.fetcher.updateFields(this.caseId, [fieldValue]).subscribe({
      next: (response: Response) => {
        this.fieldStatus[fieldValue.id] = { message: "Update successfully saved", success: true };
        console.log("saved stuff")
      },
      error: err => {
        this.fieldStatus[fieldValue.id] = { message: "Something went wrong", success: false };
        console.error("saved nothing because: ", err)
      }
    });
  }
}
