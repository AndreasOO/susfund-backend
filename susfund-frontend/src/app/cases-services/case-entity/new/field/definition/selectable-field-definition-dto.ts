import {SelectableValueDto} from '../../selectable-value-dto';
import {FieldDefinitionDto} from './field-definition-dto';

export interface SelectableFieldDefinitionDto extends FieldDefinitionDto {
  selectableValues:SelectableValueDto[]
}
