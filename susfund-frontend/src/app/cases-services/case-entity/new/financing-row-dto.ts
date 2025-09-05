import {OrganizationDto} from './organization-dto';

export interface FinancingRowDto {
  id:number,
  organization:OrganizationDto,
  financingAmount:number,
  financingPercentage:number,
  dtoClass:string
  financingType:string
}
