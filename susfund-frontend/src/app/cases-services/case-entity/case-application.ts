import {QuestionResults} from './question-results';

export interface CaseApplication {
  id:number,
  submission_date:Date,
  questionResults:QuestionResults[]
}
