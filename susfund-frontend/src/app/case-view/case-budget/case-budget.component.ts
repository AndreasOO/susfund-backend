import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {BudgetFieldValueDto} from '../../cases-services/case-entity/value/budget-field-value-dto';
import {FinancingRowDto} from '../../cases-services/case-entity/financing-row-dto';
import {BudgetRowDto} from '../../cases-services/case-entity/budget-row-dto';

@Component({
  selector: 'app-case-budget',
  standalone: false,
  templateUrl: './case-budget.component.html',
  styleUrl: './case-budget.component.css'
})
export class CaseBudgetComponent implements OnInit{

  caseId : string | undefined
  budgetFields:BudgetFieldValueDto[] = []
  fieldStatus:  {message: string, success: boolean}  | undefined ;
  // TODO get these from selectable Field def??
  costTypes: string[] = ['TYPE_1', 'TYPE_2', 'TYPE_3', 'TYPE_4'];
  financingTypes: string[] = ['CASH', 'NOT_CASH'];
  total:number | undefined


  constructor(public router:Router, public fetcher:CasesFetcherService) {
  }

  ngOnInit() {
    this.caseId = this.router.url.split("/")[this.router.url.split("/").indexOf("cases")+1];
    this.fetcher.getBudgetFieldValue(this.caseId)
      .subscribe(fields => this.budgetFields = fields)

    this.fetcher.getBudgetFieldValue(this.caseId)
      .subscribe(fields => {  this.total = this.sumBudgetRowEstimatedCosts(fields)
      });
  }

  private sumBudgetRowEstimatedCosts(budgetFields:BudgetFieldValueDto[]):number  {
    return budgetFields.flatMap(budgetFields => budgetFields.budgetRows)
        .reduce((sum, row) => sum + row.estimatedCost, 0);
    }


  // Temporary objects for new rows
  newBudgetRow = {
    costType: '',
    description: '',
    estimatedCost: 0
  };

  newFinancingRow = {
    organizationId: 0,
    organizationName: '',
    financingType: '',
    financingPercentage: 0
  };

  updateFinancingRows(budgetFieldIndex:number):void {
    this.budgetFields[budgetFieldIndex].financingRows = this.budgetFields[budgetFieldIndex].financingRows.map(v => v = {
      dtoClass:"",
      organization: {
        dtoClass:"",
        id: v.organization.id,
        name: v.organization.name,
        organizationType: v.organization.organizationType // change later
      },
      financingType: v.financingType,
      financingPercentage: v.financingPercentage,
      financingAmount: this.total!*(v.financingPercentage/100.0)
    })
  }
  addBudgetRow(budgetFieldIndex: number) {
    const newRow:BudgetRowDto = {
      dtoClass:"",
      costType: this.newBudgetRow.costType,
      description: this.newBudgetRow.description,
      estimatedCost: this.newBudgetRow.estimatedCost,
      accruedCost: 0
    };

    this.budgetFields[budgetFieldIndex].budgetRows.push(newRow);
    this.total = this.sumBudgetRowEstimatedCosts(this.budgetFields)
    this.updateFinancingRows(budgetFieldIndex)

    // Reset the form
    this.newBudgetRow = {
      costType: '',
      description: '',
      estimatedCost: 0
    };
  }

  addFinancingRow(budgetFieldIndex: number) {
    const newRow:FinancingRowDto = {
      dtoClass:"",
      organization: {
        dtoClass:"",
        id: this.newFinancingRow.organizationId,
        name: this.newFinancingRow.organizationName,
        organizationType: 'SOLE_TRADER' // change later
      },
      financingType: this.newFinancingRow.financingType,
      financingPercentage: this.newFinancingRow.financingPercentage,
      financingAmount: this.total!*(this.newFinancingRow.financingPercentage/100.0)
    };

    this.budgetFields[budgetFieldIndex].financingRows.push(newRow);

    // Reset the form
    this.newFinancingRow = {
      organizationId: 0,
      organizationName: '',
      financingType: '',
      financingPercentage: 0
    };
  }

  public save(fieldValue:any){
    this.fetcher.updateFields(this.caseId, [fieldValue]).subscribe({
      next: (response: Response) => {
        this.fieldStatus = { message: "Update successfully saved", success: true };
        console.log("saved stuff")
        this.total = this.sumBudgetRowEstimatedCosts(this.budgetFields)
        this.updateFinancingRows(0)
      },
      error: err => {
        this.fieldStatus = { message: "Something went wrong", success: false };
        console.error("saved nothing because: ", err)
      }
    });
  }
}
