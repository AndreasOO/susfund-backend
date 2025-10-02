import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {CaseEntityDto} from '../../cases-services/case-entity/case-entity-dto';
import {NextDecisionRoundState} from '../../cases-services/case-entity/next-decision-round-state';

@Component({
  selector: 'app-case-sidebar-menu',
  standalone: false,
  templateUrl: './case-sidebar-menu.component.html',
  styleUrl: './case-sidebar-menu.component.css'
})

export class CaseSidebarMenuComponent implements OnInit{

  caseId:string | undefined
  caseEntity:CaseEntityDto|undefined

  errorMessage:string|undefined

  buttonName:string|undefined
  caseLocked:boolean = false

  constructor(public router:Router, private fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getCaseById(this.caseId).subscribe(caseEntity => this.caseEntity = caseEntity!)


    this.fetcher.getNextDecisionRoundState(this.caseId).subscribe({
      next: (nextDecisionRoundState:NextDecisionRoundState) => {
        console.log(nextDecisionRoundState.displayName)
        this.buttonName = nextDecisionRoundState.displayName;
      },
      error: err => {
        this.buttonName = "Case locked"
        this.caseLocked = true;
        console.error("error fetching button name: ", err)
      }
    });
  }


  save(){
    this.fetcher.updateDecisionRoundState(this.caseId).subscribe({
      next: (response: Response) => {
        this.errorMessage = "";
        console.log("success")
        window.location.reload();
      },
      error: err => {
        this.errorMessage = "Transition not possible"
        this.caseLocked = true;
        this.buttonName = "Case locked"
        console.error("saved nothing because: ", err)
      }
    });
  }
}
