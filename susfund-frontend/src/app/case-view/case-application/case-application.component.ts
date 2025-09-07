import {Component, inject, Signal} from '@angular/core';
import {Router, ROUTER_OUTLET_DATA} from '@angular/router';
import {OnInit} from '@angular/core';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseApplicationUtil} from '../../cases-services/case-util/case-application-util';
import {ApplicationUpdateRequest} from '../../cases-services/case-util/application-update-request';
import {TextFieldValueDto} from '../../cases-services/case-entity/new/field/value/text-field-value-dto';

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

  // public saveUpdate(updatedAnswer:string, questionId:number){
  //   const update: ApplicationUpdateRequest ={
  //     questionId: questionId,
  //     answer: updatedAnswer
  //   }
  //   const response = this.fetcher.updateApplicationQuestion(this.caseId!, update).subscribe(response =>{
  //     console.log(response)
  //   },
  //     error => console.log(error)
  //   );
  // }
}



// export class CaseApplicationComponent implements OnInit {
//
//   // public caseId:string | undefined;
//   // public caseApplicationUtil: CaseApplicationUtil | undefined;
//
//   public textFieldValues:TextFieldValueDto[] = []
//
//   constructor(public router:Router, public fetcher:CasesFetcherService) {
//   }
//
//   ngOnInit() {
//
//     // this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
//     // this.fetcher.getApplicationUtilByCaseId(this.caseId).subscribe(caseApplicationUtil => this.caseApplicationUtil = caseApplicationUtil)
//
//     this.fetcher.getApplicationFields().subscribe(textFields => {this.textFieldValues = textFields!;});
//
//   }
//
//   // public saveUpdate(updatedAnswer:string, questionId:number){
//   //   const update: ApplicationUpdateRequest ={
//   //     questionId: questionId,
//   //     answer: updatedAnswer
//   //   }
//   //   const response = this.fetcher.updateApplicationQuestion(this.caseId!, update).subscribe(response =>{
//   //     console.log(response)
//   //   },
//   //     error => console.log(error)
//   //   );
//   // }
// }
