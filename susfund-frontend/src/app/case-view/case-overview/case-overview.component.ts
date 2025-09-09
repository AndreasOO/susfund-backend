import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseEntityDto} from '../../cases-services/case-entity/case-entity-dto';

@Component({
  selector: 'app-case-overview',
  standalone: false,
  templateUrl: './case-overview.component.html',
  styleUrl: './case-overview.component.css'
})
export class CaseOverviewComponent implements OnInit{

  caseId:string|undefined
  caseEntity:CaseEntityDto | undefined

  constructor(public router:Router, private fetcher:CasesFetcherService) {

  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getCaseById(this.caseId).subscribe(caseEntity => this.caseEntity = caseEntity!)
  }

}


// export class CaseOverviewComponent implements OnInit{
//
//   caseId:string | undefined
//
//   currentCaseManager:CaseManager | undefined
//   currentCaseController:CaseManager | undefined
//   currentHandledBy:CaseManager | undefined
//
//   caseManagerList:CaseManager[] | undefined
//   caseDetails:CaseDetails | undefined
//   caseBudget : CaseBudget | undefined
//
//   selectedCaseManagerId:number | undefined
//   selectedCaseControllerId:number | undefined
//   selectedHandledById:number | undefined
//
//   errorMessage: string | null = null
//   successMessage: string | null = null
//
//   constructor(public router:Router, private fetcher:CasesFetcherService) {
//
//   }
//
//   ngOnInit() {
//     this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
//     this.fetcher.getCaseById(this.caseId).subscribe(caseDetails => this.caseDetails = caseDetails!)
//     this.fetcher.getAllCaseManagers().subscribe(caseManagerList => this.caseManagerList = caseManagerList!)
//     this.fetcher.getBudgetByCaseId(this.caseId).subscribe(caseBudget => this.caseBudget = caseBudget!)
//
//     this.fetcher.getCaseManagerByCaseId(this.caseId).subscribe(caseManager => {
//       this.currentCaseManager = caseManager!;
//       this.selectedCaseManagerId = this.currentCaseManager?.id;
//     });
//
//     this.fetcher.getCaseControllerByCaseId(this.caseId).subscribe(caseController => {
//       this.currentCaseController = caseController!;
//       this.selectedCaseControllerId = this.currentCaseController?.id;
//     });
//
//     this.fetcher.getHandledByByCaseId(this.caseId).subscribe(handledBy => {
//       this.currentHandledBy = handledBy!;
//       this.selectedHandledById = this.currentHandledBy?.id;
//     });
//
//
//   }
//
//   getTotalBudget(): number {
//     return this.caseBudget?.budgetPosts.map(post => post.estimatedCost).reduce((a, b) => a + b, 0) ?? 0;
//   }
//
//   saveCaseManagerUpdate(){
//     const payload = {
//       caseManagerId: String(this.selectedCaseManagerId),
//       caseControllerId: String(this.selectedCaseControllerId),
//       handledById: String(this.selectedHandledById)
//     }
//
//     this.fetcher.updateAssignedCaseManager(this.caseId!, payload).subscribe({
//       next: response => {
//         this.successMessage = response.message;
//         this.errorMessage = null
//       },
//       error: err => {
//         if (err.status === 400){
//           this.errorMessage = err.error?.error;
//           this.successMessage = null
//         }
//       }
//     })
//   }
// }
