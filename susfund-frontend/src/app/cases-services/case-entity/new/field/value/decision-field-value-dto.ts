import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {FieldValueDto} from './field-value-dto';
import {SelectableFieldDefinitionDto} from '../definition/selectable-field-definition-dto';

export interface DecisionFieldValueDto extends FieldValueDto {
  decisionResultType:string | null,
  motivation:string,
  owningFieldDefinition: SelectableFieldDefinitionDto
}
