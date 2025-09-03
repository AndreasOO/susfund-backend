
import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface TextFieldValueDto {
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  stringValue:string
}
