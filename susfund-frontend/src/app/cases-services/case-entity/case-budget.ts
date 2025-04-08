import {BudgetPost} from './budget-post';
import {Organization} from './organization';

export interface CaseBudget {
  id:number,
  dateLastChanged:Date,
  budgetPosts:BudgetPost[],
  financingOrganizations:Organization[]
}
