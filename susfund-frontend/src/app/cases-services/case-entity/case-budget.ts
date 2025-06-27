import {BudgetPost} from './budget-post';
import {Organization} from './organization';
import {Financing} from './financing';

export interface CaseBudget {
  id:number,
  dateLastChanged:Date,
  budgetPosts:BudgetPost[],
  financingOrganizations:Organization[]
  financing: Financing[]
}
