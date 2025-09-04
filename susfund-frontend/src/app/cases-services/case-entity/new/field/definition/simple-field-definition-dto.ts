export interface SimpleFieldDefinitionDto {
  id: number,
  title: string,
  preamble: string,
  assistingText: string,
  hasComment:boolean,
  section:string,
  subSection:string,
  frontendLocation:string,
  rowIndex:number,
  fieldType:string,
  endDate:Date | null,
  startDate:Date | null,
}
