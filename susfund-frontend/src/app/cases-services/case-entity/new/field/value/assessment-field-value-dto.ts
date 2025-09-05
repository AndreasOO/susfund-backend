import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';
import {FieldValueDto} from './field-value-dto';

export interface AssessmentFieldValueDto extends FieldValueDto {
  assessmentScore:number,
  assessmentJustification:string,
}
