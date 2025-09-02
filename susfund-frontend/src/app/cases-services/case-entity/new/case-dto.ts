import {OrganizationDto} from './organization-dto';
import {CaseManagerDto} from './case-manager-dto';
import {SupportTypeNodeDto} from './support-type-node-dto';
import {FieldDefinitionDto} from './field/definition/field-definition-dto';

export interface CaseDto {
  id:number,
  name:string,
  organization:OrganizationDto
  caseManager:CaseManagerDto,
  caseController:CaseManagerDto,
  handledBy:CaseManagerDto,
  caseStatus:string,
  caseDecisionType:string,
  supportTypeNode:SupportTypeNodeDto,
  fieldDefinitions:FieldDefinitionDto[],
  dtoClass:string
}
