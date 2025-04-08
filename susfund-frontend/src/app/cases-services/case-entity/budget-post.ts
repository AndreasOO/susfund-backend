import {BudgetPostType} from './budget-post-type';

export interface BudgetPost {
  id:number,
  estimatedCost:number
  budgetPostType:BudgetPostType
}
