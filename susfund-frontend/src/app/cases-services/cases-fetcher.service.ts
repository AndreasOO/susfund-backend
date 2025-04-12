import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map,Observable} from 'rxjs';
import {CaseDTO} from './case-entity/case-dto';
import {CaseLazy} from './case-entity/case-lazy';
import {CaseDetails} from './case-entity/case-details';
import {Organization} from './case-entity/organization';
import {CaseManager} from './case-entity/case-manager';
import {CaseStatus} from './case-entity/case-status';
import {CaseDecisionType} from './case-entity/case-decision-type';
import {CaseBudget} from './case-entity/case-budget';
import {CaseAssessmentUtil} from './case-util/case-assessment-util';
import {CaseApplicationUtil} from './case-util/case-application-util';
import {HistoryEvent} from './case-entity/history-event';
import {CaseDecision} from './case-entity/case-decision';
import {CaseDecisionResult} from './case-entity/case-decision-result';
import {ApplicationUpdateRequest} from './case-util/application-update-request';
import {CaseApplication} from './case-entity/case-application';
import {AssessmentUpdateRequest} from './case-util/assessment-update-request';
import {LoginRequest} from './case-util/login-request';
import {TokenBearer} from './case-util/token-bearer';

@Injectable({
  providedIn: 'root'
})
export class CasesFetcherService {

  constructor(private http:HttpClient) {
  }

  public getAllCases():Observable<CaseLazy[]> {
    return this.http.get<CaseDTO[]>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases")
                    .pipe(map(casesDTOs => casesDTOs.map(caseDTO => {
                      return {
                        id: caseDTO.id,
                        name:caseDTO.name,
                        companyName:caseDTO.organization.name,
                        companyId:caseDTO.organization.id,
                        caseManager:caseDTO.caseManager.name,
                        controller:caseDTO.caseManager.name,
                        caseStatus:caseDTO.caseStatus.name,
                        caseDecisionType:caseDTO.caseDecisionType.name
                      }
    })))
  }

  public getCasesLazyByCaseOrganization(id:string | undefined):Observable<CaseLazy[]> {
    return this.http.get<CaseDTO[]>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/"+id+"/casesrelatedtocaseorganization")
      .pipe(map(casesDTOs => casesDTOs.map(caseDTO => {
        return {
          id: caseDTO.id,
          name:caseDTO.name,
          companyName:caseDTO.organization.name,
          companyId:caseDTO.organization.id,
          caseManager:caseDTO.caseManager.name,
          controller:caseDTO.caseManager.name,
          caseStatus:caseDTO.caseStatus.name,
          caseDecisionType:caseDTO.caseDecisionType.name
        }
      })))
  }

  public getCaseById(id:string | undefined):Observable<CaseDetails> {
    return this.http.get<CaseDTO>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id)
                    .pipe(map(caseDTO => {
                      return {
                        id:caseDTO.id,
                        name:caseDTO.name,
                        organization:caseDTO.organization,
                        caseManager:caseDTO.caseManager,
                        caseStatus:caseDTO.caseStatus,
                        caseDecisionType:caseDTO.caseDecisionType,
                        caseDecision:caseDTO.caseDecision,
                        caseApplication:caseDTO.caseApplication,
                        caseAssessment:caseDTO.caseAssessment,
                        caseBudget:caseDTO.caseBudget,
                        historyEventList:caseDTO.historyEventList
                      }
    }))
  }

  public getCaseAssessmentUtilByCaseId(id:string | undefined):Observable<CaseAssessmentUtil> {
    return this.http.get<CaseAssessmentUtil>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/assessment");
  }

  public getApplicationUtilByCaseId(id:string | undefined):Observable<CaseApplicationUtil> {
    return this.http.get<CaseApplicationUtil>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/application");

  }
  public getBudgetByCaseId(id:string | undefined):Observable<CaseBudget>{
    return this.http.get<CaseBudget>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/budget");
  }

  public getHistoryEventByCaseId(id:string | undefined):Observable<HistoryEvent[]> {
    return this.http.get<HistoryEvent[]>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/history")
  }

  public getCaseManagerByCaseId(id:string | undefined):Observable<CaseManager> {
    return this.http.get<CaseManager>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/casemanager")
  }

  public getAllCaseManagers():Observable<CaseManager[]> {
    return this.http.get<CaseManager[]>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/casemanagers")
  }

  public getCaseDecisionByCaseId(id:string | undefined):Observable<CaseDecision> {
    return this.http.get<CaseDecision>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/decision")
  }

  public getCaseDecisionTypeByCaseId(id:string | undefined):Observable<CaseDecisionType> {
    return this.http.get<CaseDecisionType>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/decisiontype")
  }

  public getCaseStatusByCaseId(id:string | undefined):Observable<CaseStatus> {
    return this.http.get<CaseStatus>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/status")
  }


  public getAllCaseDecisionResultOptions():Observable<CaseDecisionResult[]> {
    return this.http.get<CaseDecisionResult[]>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/casedecisionresults")
  }

  public updateApplicationQuestion(caseId:string, update:ApplicationUpdateRequest):Observable<any> {
    return this.http.put("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + caseId + "/application", update)
  }

  public updateAssessmentItem(caseId:string, update:AssessmentUpdateRequest):Observable<any>{
    return this.http.put("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + caseId + "/assessment", update)
  }

  public getOrganizationByCaseId(id:string | undefined):Observable<Organization> {
    return this.http.get<Organization>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/cases/" + id + "/organization")
  }

  public login(loginRequest:LoginRequest): Observable<TokenBearer>{
    return this.http.put<TokenBearer>("http://localhost:8080/SusFund-1.0-SNAPSHOT/api/auth/login", loginRequest)
  }


}
