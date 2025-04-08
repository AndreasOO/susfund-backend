import {AssessmentItem} from './assessment-item';

export interface AssessmentResult {
  id:number,
  score:number,
  justification:string
  assessmentItem:AssessmentItem
}
