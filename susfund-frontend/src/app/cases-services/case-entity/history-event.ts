import {EventType} from './event-type';

export interface HistoryEvent {
  id: number,
  details: string,
  date: Date,
  eventType: EventType
}
