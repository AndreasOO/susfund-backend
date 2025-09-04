import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface AssessmentFieldValueDto {
  id:number,
  fieldDefinition:SimpleFieldDefinitionDto
  assessmentScore:number,
  assessmentJustification:string,
  valueAsString:string
}
