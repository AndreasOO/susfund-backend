import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {HistoryEventDto} from '../../history-event-dto';

export interface HistoryLogFieldValueDto {
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto,
  historyEvents:HistoryEventDto[]
}
