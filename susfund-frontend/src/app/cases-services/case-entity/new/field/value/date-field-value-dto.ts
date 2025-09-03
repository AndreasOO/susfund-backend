import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface DateFieldValueDto {
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  dateValue:Date
}
