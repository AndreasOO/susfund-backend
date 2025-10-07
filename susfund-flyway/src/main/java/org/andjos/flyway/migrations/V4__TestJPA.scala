package org.andjos.flyway.migrations

import jakarta.persistence.EntityManager
import org.andjos.flyway.base.JPAMigrationBase
import org.andjos.susfund.entity.caseentity.{CaseDecisionType, CaseEntity, CaseStatus}
import org.andjos.susfund.entity.casemanager.CaseManager
import org.andjos.susfund.entity.field.definition.FieldDefinition
import org.andjos.susfund.entity.field.definition.fieldtype.FieldType
import org.andjos.susfund.entity.field.definition.section.{Section, SubSection}
import org.andjos.susfund.entity.organization.Organization
import org.andjos.susfund.entity.supporttype.SupportTypeNode

class V4__TestJPA  extends JPAMigrationBase {

  override protected def migrate(em: EntityManager): Unit = {

    val fdn1:FieldDefinition = new FieldDefinition
    fdn1.setTitle("sustainability application question for PROJ title")
    fdn1.setPreamble("sustainability application question for PROJ preamble")
    fdn1.setAssistingText("sustainability application question for assisting text")
    fdn1.setHasComment(true)
    fdn1.setSection(Section.APPLICATION)
    fdn1.setSubSection(SubSection.SUSTAINABILITY)
    fdn1.setFieldType(FieldType.APPLICATION_QUESTION)
    fdn1.setRowIndex(1)
    em.persist(fdn1)

    val fdn1Saved:FieldDefinition = em.merge(fdn1)

    val fdn2:FieldDefinition = new FieldDefinition
    fdn2.setTitle("economic feasibility application question for PROJ title")
    fdn2.setPreamble("economic feasibility application question for PROJ preamble")
    fdn2.setAssistingText("economic feasibility application question for PROJ assisting text")
    fdn2.setHasComment(true)
    fdn2.setSection(Section.APPLICATION)
    fdn2.setSubSection(SubSection.ECONOMIC_FEASIBILITY)
    fdn2.setFieldType(FieldType.APPLICATION_QUESTION)
    fdn2.setRowIndex(2)
    em.persist(fdn2)

    val fdn2Saved:FieldDefinition = em.merge(fdn2);

    val fdn3:FieldDefinition = new FieldDefinition
    fdn3.setTitle("regional growth application question for PROJ title")
    fdn3.setPreamble("regional growth application question for PROJ preamble")
    fdn3.setAssistingText("regional growth application question for PROJ assisting text")
    fdn3.setHasComment(true)
    fdn3.setSection(Section.APPLICATION)
    fdn3.setSubSection(SubSection.REGIONAL_GROWTH)
    fdn3.setFieldType(FieldType.APPLICATION_QUESTION)
    fdn3.setRowIndex(3)
    em.persist(fdn3)

    val fdn3Saved:FieldDefinition = em.merge(fdn3);

    val fdn4:FieldDefinition = new FieldDefinition
    fdn4.setTitle("budget assessment for PROJ title")
    fdn4.setPreamble("budget assessment for PROJ preamble")
    fdn4.setAssistingText("budget assessment for PROJ assisting text")
    fdn4.setHasComment(true)
    fdn4.setSection(Section.ASSESSMENT)
    fdn4.setSubSection(SubSection.BUDGET)
    fdn4.setFieldType(FieldType.ASSESSMENT_QUESTION)
    fdn4.setRowIndex(1)
    em.persist(fdn4)

    val fdn4Saved:FieldDefinition = em.merge(fdn4);

    val fdn5:FieldDefinition = new FieldDefinition
    fdn5.setTitle("company assessment for PROJ title")
    fdn5.setPreamble("company assessment for PROJ preamble")
    fdn5.setAssistingText("company assessment for PROJ assisting text")
    fdn5.setHasComment(true)
    fdn5.setSection(Section.ASSESSMENT)
    fdn5.setSubSection(SubSection.COMPANY)
    fdn5.setFieldType(FieldType.ASSESSMENT_QUESTION)
    fdn5.setRowIndex(1)
    em.persist(fdn5)

    val fdn5Saved:FieldDefinition = em.merge(fdn5)

    val fdn6:FieldDefinition = new FieldDefinition
    fdn6.setTitle("decision assessment for PROJ title")
    fdn6.setPreamble("decision assessment for PROJ preamble")
    fdn6.setAssistingText("decision assessment for PROJ assisting text")
    fdn6.setHasComment(true)
    fdn6.setSection(Section.ASSESSMENT)
    fdn6.setSubSection(SubSection.DECISION)
    fdn6.setFieldType(FieldType.ASSESSMENT_QUESTION)
    fdn6.setRowIndex(2)
    em.persist(fdn6)

    val fdn6Saved:FieldDefinition = em.merge(fdn6)



    val fdn7:FieldDefinition = em.createQuery("SELECT fd FROM FieldDefinition fd where fd.id= :id",
        classOf[FieldDefinition])
      .setParameter("id", 7)
      .getSingleResult

    val fdn8:FieldDefinition = em.createQuery("SELECT fd FROM FieldDefinition fd where fd.id= :id",
        classOf[FieldDefinition])
      .setParameter("id", 8)
      .getSingleResult

    val fdn9:FieldDefinition = em.createQuery("SELECT fd FROM FieldDefinition fd where fd.id= :id",
        classOf[FieldDefinition])
      .setParameter("id", 11)
      .getSingleResult


    val caseManager:CaseManager = em.createQuery("SELECT cm FROM CaseManager cm where cm.id= :id",
        classOf[CaseManager])
      .setParameter("id", 4)
      .getSingleResult

    val caseController:CaseManager = em.createQuery("SELECT cm FROM CaseManager cm where cm.id= :id",
        classOf[CaseManager])
      .setParameter("id", 5)
      .getSingleResult

    val handledBy:CaseManager = em.createQuery("SELECT cm FROM CaseManager cm where cm.id= :id",
        classOf[CaseManager])
      .setParameter("id", 1)
      .getSingleResult

    val organization:Organization = em.createQuery("SELECT oz FROM Organization oz where oz.id= :id",
        classOf[Organization])
      .setParameter("id", 1)
      .getSingleResult

    val stn:SupportTypeNode = new SupportTypeNode
    stn.setTechName("PROJ/2024/REGIONAL_INVESTMENT/INFRASTRUCTURE")

    stn.getFieldDefinitions.addAll(java.util.Arrays.asList(fdn1Saved, fdn2Saved, fdn3Saved, fdn4Saved, fdn5Saved, fdn6Saved, fdn7, fdn8, fdn9))

    em.persist(stn)

    val caze:CaseEntity = new CaseEntity()
    caze.setName("Test case 3")
    caze.setCaseStatus(CaseStatus.UNDER_PREPARATION)
    caze.setCaseDecisionType(CaseDecisionType.APPLICATION_APPROVAL)
    caze.setCaseManager(caseManager)
    caze.setCaseController(caseController)
    caze.setOrganization(organization)
    caze.setSupportTypeNode(stn)
    caze.setHandledBy(handledBy)

    em.persist(caze)

    val caseSaved:CaseEntity = em.merge(caze)

    val fve1 = fdn1Saved.createFieldValue(caseSaved)
    caseSaved.getFieldValues.add(fve1)

    val fve2 = fdn2Saved.createFieldValue(caseSaved);
    caseSaved.getFieldValues.add(fve2)

    val fve3 = fdn3Saved.createFieldValue(caseSaved);
    caseSaved.getFieldValues.add(fve3)

    val fve4 = fdn4Saved.createFieldValue(caseSaved);
    caseSaved.getFieldValues.add(fve4)

    val fve6 = fdn6Saved.createFieldValue(caseSaved);
    caseSaved.getFieldValues.add(fve6)

    val fve7 = fdn7.createFieldValue(caseSaved)
    caseSaved.getFieldValues.add(fve7)

    val fve8 = fdn8.createFieldValue(caseSaved)
    caseSaved.getFieldValues.add(fve8)

    em.persist(fve1)
    em.persist(fve2)
    em.persist(fve3)
    em.persist(fve4)
    em.persist(fve6)
    em.persist(fve7)
    em.persist(fve8)

  }

}
