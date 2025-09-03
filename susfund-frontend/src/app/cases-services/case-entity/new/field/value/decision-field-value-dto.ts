import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface DecisionFieldValueDto {
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  decisionResultType:string
}
