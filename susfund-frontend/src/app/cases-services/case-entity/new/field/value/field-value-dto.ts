import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface FieldValueDto {
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
}
