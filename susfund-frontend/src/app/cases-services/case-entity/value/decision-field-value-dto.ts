import {FieldValueDto} from './field-value-dto';
import {SelectableFieldDefinitionDto} from '../definition/selectable-field-definition-dto';
import {CaseManagerDto} from '../case-manager-dto';

export interface DecisionFieldValueDto extends FieldValueDto {
  decisionResultType:string | null,
  motivation:string,
  decisionController: CaseManagerDto,
  owningFieldDefinition: SelectableFieldDefinitionDto
}
