import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {HistoryEventDto} from '../../history-event-dto';
import {FieldValueDto} from './field-value-dto';

export interface HistoryLogFieldValueDto extends FieldValueDto {
  historyEvents:HistoryEventDto[]
}
