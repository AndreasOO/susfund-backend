import {SelectableValueDto} from '../../selectable-value-dto';
import {SimpleFieldDefinitionDto} from './simple-field-definition-dto';

export interface SelectableFieldDefinitionDto extends SimpleFieldDefinitionDto {
  selectableValues:SelectableValueDto[]
}
