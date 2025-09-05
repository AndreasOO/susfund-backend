import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {SelectableFieldDefinitionDto} from '../definition/selectable-field-definition-dto';
import {BudgetFieldValueDto} from './budget-field-value-dto';
import {BudgetFieldDefinitionDto} from '../definition/budget-field-definition-dto';

export interface FieldValueDto {
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto | SelectableFieldDefinitionDto | BudgetFieldDefinitionDto
}
