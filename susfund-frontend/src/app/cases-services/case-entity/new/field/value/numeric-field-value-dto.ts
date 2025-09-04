import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface NumericFieldValueDto {
  id:number,
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  numericValue:number
}
