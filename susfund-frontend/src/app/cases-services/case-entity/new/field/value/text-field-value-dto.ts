import {FieldDefinitionDto} from '../definition/field-definition-dto';

export interface TextFieldValueDto {
  stringValue:string
  owningCaseId:number,
  owningFieldDefinition:FieldDefinitionDto,
  dtoClass:string
}
