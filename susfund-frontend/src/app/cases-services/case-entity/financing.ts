import {FinancingType} from './financing-type';
import {Organization} from './organization';

export interface Financing {
  id: number,
  estimatedFinancingInPercentage: number,
  estimatedFinancingInMoney: number,
  financingType: FinancingType
  organization: Organization
}
