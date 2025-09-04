import {OrganizationDto} from './organization-dto';
import {CaseManagerDto} from './case-manager-dto';
import {SupportTypeNodeDto} from './support-type-node-dto';
import {SimpleFieldDefinitionDto} from './field/definition/simple-field-definition-dto';
import {FieldValueDto} from './field/value/field-value-dto';

export interface CaseEntityDto {
  id:number,
  name:string,
  organization:OrganizationDto
  caseManager:CaseManagerDto,
  caseController:CaseManagerDto,
  handledBy:CaseManagerDto,
  caseStatus:string,
  caseDecisionType:string,
  supportTypeNode:SupportTypeNodeDto,
  fields:FieldValueDto[],
  dtoClass:string
}
