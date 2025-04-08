import {CaseDecisionResult} from './case-decision-result';

export interface CaseDecision {
  id: number,
  caseDecisionResult: CaseDecisionResult
  justification:string
}
