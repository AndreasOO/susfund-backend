import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface DateFieldValueDto {
  id:number,
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  dateValue:Date
}
