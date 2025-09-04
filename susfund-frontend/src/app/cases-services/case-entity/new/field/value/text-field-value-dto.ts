
import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {FieldValueDto} from './field-value-dto';

export interface TextFieldValueDto extends FieldValueDto {
  stringValue:string,
}
