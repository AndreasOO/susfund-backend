import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {FinancingRowDto} from '../../financing-row-dto';
import {BudgetRowDto} from '../../budget-row-dto';

export interface BudgetFieldValueDto {
  id:number,
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  totalFinancingRatio:number,
  financingRows:FinancingRowDto[]
  budgetRows:BudgetRowDto[]
}
