import {SimpleFieldDefinitionDto} from '../definition/simple-field-definition-dto';

export interface AssessmentFieldValueDto {
  dtoClass:string,
  owningCaseId:number,
  owningFieldDefinition:SimpleFieldDefinitionDto
  assessmentScore:number,
  assessmentJustification:string
}
