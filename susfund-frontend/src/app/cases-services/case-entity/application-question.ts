import {ApplicationSection} from './application-section';

export interface ApplicationQuestion {
  id:number,
  title:string,
  preamble:string,
  assistingText:string,
  applicationSection:ApplicationSection
}
