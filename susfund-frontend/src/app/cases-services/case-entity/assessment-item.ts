import {AssessmentSection} from './assessment-section';

export interface AssessmentItem {
  id:number,
  title:string,
  preamble:string,
  assistingText:string,
  assessmentSection: AssessmentSection
}
