import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {FinancingRowDto} from '../../financing-row-dto';
import {BudgetRowDto} from '../../budget-row-dto';
import {FieldValueDto} from './field-value-dto';

export interface BudgetFieldValueDto extends FieldValueDto {
  totalFinancingRatio:number,
  financingRows:FinancingRowDto[]
  budgetRows:BudgetRowDto[]
}
