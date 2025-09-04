
import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface TextFieldValueDto {
  id:number,
  fieldDefinition:SimpleFieldDefinitionDto,
  stringValue:string,
  valueAsString:string
}
