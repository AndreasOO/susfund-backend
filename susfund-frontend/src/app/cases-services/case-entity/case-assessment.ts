import {AssessmentResult} from './assessment-result';

export interface CaseAssessment {
  id:number,
  assessmentDate:Date,
  assessmentResults:AssessmentResult[]
}
