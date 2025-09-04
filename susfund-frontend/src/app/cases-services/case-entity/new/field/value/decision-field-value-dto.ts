import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface DecisionFieldValueDto {
  id:number,
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  decisionResultType:string
}
