import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map,Observable} from 'rxjs';
import {LoginRequest} from './case-util/login-request';
import {TokenBearer} from './case-util/token-bearer';
import {SimpleCaseDto} from './case-entity/simple-case-dto';
import {AssessmentFieldValueDto} from './case-entity/value/assessment-field-value-dto';
import {TextFieldValueDto} from './case-entity/value/text-field-value-dto';
import {CaseEntityDto} from './case-entity/case-entity-dto';
import {OrganizationDto} from './case-entity/organization-dto';
import {DecisionFieldValueDto} from './case-entity/value/decision-field-value-dto';
import {BudgetFieldValueDto} from './case-entity/value/budget-field-value-dto';
import {HistoryLogFieldValueDto} from './case-entity/value/history-log-field-value-dto';
import {CaseManagerDto} from './case-entity/case-manager-dto';
import {FieldValueDto} from './case-entity/value/field-value-dto';

@Injectable({
  providedIn: 'root'
})
export class CasesFetcherService {
  private readonly baseUri:string

  constructor(private http:HttpClient) {
    this.baseUri="http://localhost:8080";
  }

  public getAllCaseManagers():Observable<CaseManagerDto[]> {
    return this.http.get<CaseManagerDto[]>(this.baseUri+"/susfund/api/cases/casemanagers")
  }

  public login(loginRequest:LoginRequest): Observable<TokenBearer>{
    return this.http.put<TokenBearer>(this.baseUri+"/susfund/api/auth/login", loginRequest)
  }

  public getAssessmentFields(caseId:string | undefined):Observable<AssessmentFieldValueDto[]> {
    return this.http.get<AssessmentFieldValueDto[]>(this.baseUri+"/susfund/api/cases/" + caseId + "/assessment-fields")
  }

  public getApplicationFields(caseId:string | undefined):Observable<TextFieldValueDto[]> {
    return this.http.get<TextFieldValueDto[]>(this.baseUri+"/susfund/api/cases/" + caseId + "/application-fields")
  }

  public getOrganization(caseId:string |undefined):Observable<OrganizationDto> {
    return this.http.get<OrganizationDto>(this.baseUri+"/susfund/api/cases/" + caseId + "/organization")
  }

  public getDecisionFieldValue(caseId:string | undefined):Observable<DecisionFieldValueDto[]> {
    return this.http.get<DecisionFieldValueDto[]>(this.baseUri+"/susfund/api/cases/" + caseId + "/decision-field")
  }

  public getBudgetFieldValue(caseId:string | undefined):Observable<BudgetFieldValueDto[]> {
    return this.http.get<BudgetFieldValueDto[]>(this.baseUri+"/susfund/api/cases/" + caseId + "/budget-field")
  }

  public getHistoryFieldValue(caseId:string | undefined):Observable<HistoryLogFieldValueDto[]> {
    return this.http.get<HistoryLogFieldValueDto[]>(this.baseUri+"/susfund/api/cases/" + caseId + "/history-field")
  }

  public getAllCaseEntities():Observable<SimpleCaseDto[]> {
    return this.http.get<SimpleCaseDto[]>(this.baseUri+"/susfund/api/cases/simple")
  }

  public getCaseById(id:string | undefined):Observable<CaseEntityDto> {
    return this.http.get<CaseEntityDto>(this.baseUri+"/susfund/api/cases/" + id)
  }

  public updateFields(id:string | undefined, fields : FieldValueDto[]): Observable<Response> {
    return this.http.post<Response>(this.baseUri+"/susfund/api/cases/" + id + "/savefields", fields);
  }

  public updateDecisionRoundState(id:string|undefined):Observable<Response> {
    return this.http.get<Response>(this.baseUri+"/susfund/api/cases/" + id + "/decisionroundstatetransition");
  }

}
