package org.andjos.flyway.migrations

import jakarta.persistence.EntityManager
import org.andjos.flyway.base.JPAMigrationBase
import org.andjos.susfund.entity.caseentity.{CaseDecisionType, CaseEntity, CaseStatus}
import org.andjos.susfund.entity.field.definition.FieldDefinition
import org.andjos.susfund.entity.field.definition.fieldtype.FieldType
import org.andjos.susfund.entity.field.definition.section.{Section, SubSection}
import org.andjos.susfund.entity.organization.{Organization, OrganizationType}
import org.andjos.susfund.entity.supporttype.SupportTypeNode

class V3__TestJPA extends JPAMigrationBase {

  override protected def migrate(em: EntityManager): Unit = {

    val fdn1:FieldDefinition = new FieldDefinition
    fdn1.setTitle("test JPA application sustainability title")
    fdn1.setPreamble("test JPA application sustainability preamble")
    fdn1.setAssistingText("test JPA application sustainability AssistingText")
    fdn1.setHasComment(true)
    fdn1.setSection(Section.APPLICATION)
    fdn1.setSubSection(SubSection.SUSTAINABILITY)
    fdn1.setFieldType(FieldType.APPLICATION_QUESTION)
    fdn1.setRowIndex(9)
    em.persist(fdn1)

    val fdn1Saved:FieldDefinition = em.merge(fdn1)

    val fdn2:FieldDefinition = new FieldDefinition
    fdn2.setTitle("application question 2 title ")
    fdn2.setPreamble("application question 2 preamble")
    fdn2.setAssistingText("application question 2 assisting text")
    fdn2.setHasComment(true)
    fdn2.setSection(Section.APPLICATION)
    fdn2.setSubSection(SubSection.ECONOMIC_FEASIBILITY)
    fdn2.setFieldType(FieldType.APPLICATION_QUESTION)
    fdn2.setRowIndex(2)
    em.persist(fdn2)

    val fdn2Saved:FieldDefinition = em.merge(fdn2);

    val fdn3:FieldDefinition = new FieldDefinition
    fdn3.setTitle("application question 3 title")
    fdn3.setPreamble("application question 3 preamble")
    fdn3.setAssistingText("application question 3 assisting text")
    fdn3.setHasComment(true)
    fdn3.setSection(Section.APPLICATION)
    fdn3.setSubSection(SubSection.REGIONAL_GROWTH)
    fdn3.setFieldType(FieldType.APPLICATION_QUESTION)
    fdn3.setRowIndex(3)
    em.persist(fdn3)

    val fdn3Saved:FieldDefinition = em.merge(fdn3);

    val fdn4:FieldDefinition = new FieldDefinition
    fdn4.setTitle("application question 4 title")
    fdn4.setPreamble("application question 4 preamble")
    fdn4.setAssistingText("application question 4 assisting text")
    fdn4.setHasComment(true)
    fdn4.setSection(Section.APPLICATION)
    fdn4.setSubSection(SubSection.FINANCING)
    fdn4.setFieldType(FieldType.APPLICATION_QUESTION)
    fdn4.setRowIndex(4)
    em.persist(fdn4)

    val fdn4Saved:FieldDefinition = em.merge(fdn4);

    val fdn5:FieldDefinition = new FieldDefinition
    fdn5.setTitle("assessment 1 title")
    fdn5.setPreamble("assessment 1 preamble")
    fdn5.setAssistingText("assessment 1 assisting text")
    fdn5.setHasComment(true)
    fdn5.setSection(Section.ASSESSMENT)
    fdn5.setSubSection(SubSection.BUDGET)
    fdn5.setFieldType(FieldType.ASSESSMENT_QUESTION)
    fdn5.setRowIndex(1)
    em.persist(fdn5)

    val fdn5Saved:FieldDefinition = em.merge(fdn5)

    val fdn6:FieldDefinition = new FieldDefinition
    fdn6.setTitle("assessment 2 title")
    fdn6.setPreamble("assessment 2 preamble")
    fdn6.setAssistingText("assessment 2 assisting text")
    fdn6.setHasComment(true)
    fdn6.setSection(Section.ASSESSMENT)
    fdn6.setSubSection(SubSection.COMPANY)
    fdn6.setFieldType(FieldType.ASSESSMENT_QUESTION)
    fdn6.setRowIndex(2)
    em.persist(fdn6)

    val fdn6Saved:FieldDefinition = em.merge(fdn6);

    val fdn7:FieldDefinition = new FieldDefinition
    fdn7.setTitle("assessment 3 title")
    fdn7.setPreamble("assessment 3 preamble")
    fdn7.setAssistingText("assessment 3 assisting text")
    fdn7.setHasComment(true)
    fdn7.setSection(Section.ASSESSMENT)
    fdn7.setSubSection(SubSection.DECISION)
    fdn7.setFieldType(FieldType.ASSESSMENT_QUESTION)
    fdn7.setRowIndex(3)
    em.persist(fdn7)

    val fdn7Saved:FieldDefinition = em.merge(fdn7);

    val fdn8:FieldDefinition = new FieldDefinition
    fdn8.setTitle("assessment 4 title")
    fdn8.setPreamble("assessment 4 preamble")
    fdn8.setAssistingText("assessment 4 assisting text")
    fdn8.setHasComment(true)
    fdn8.setSection(Section.ASSESSMENT)
    fdn8.setSubSection(SubSection.DECISION)
    fdn8.setFieldType(FieldType.ASSESSMENT_QUESTION)
    fdn8.setRowIndex(4)
    em.persist(fdn8)

    val fdn8Saved:FieldDefinition = em.merge(fdn8);





    val stn:SupportTypeNode = em.createQuery("SELECT stn FROM SupportTypeNode stn WHERE stn.techName = :techName",
        classOf[SupportTypeNode])
      .setParameter("techName","FTG/2022/REGIONAL_INVESTMENT/INFRASTRUCTURE")
      .getSingleResult

    stn.getFieldDefinitions.addAll(java.util.Arrays.asList(fdn1Saved, fdn2Saved, fdn3Saved, fdn4Saved, fdn5Saved, fdn6Saved, fdn7Saved, fdn8Saved))
    em.persist(stn)


    val caze:CaseEntity = em.createQuery("SELECT ce FROM CaseEntity ce where ce.id= :id",
      classOf[CaseEntity])
      .setParameter("id", 1)
      .getSingleResult

    val fve1 = fdn1Saved.createFieldValue(caze)
    caze.getFieldValues.add(fve1)

    val fve2 = fdn2Saved.createFieldValue(caze);
    caze.getFieldValues.add(fve2)

    val fve3 = fdn3Saved.createFieldValue(caze);
    caze.getFieldValues.add(fve3)

    val fve4 = fdn4Saved.createFieldValue(caze);
    caze.getFieldValues.add(fve4)

    val fve6 = fdn6Saved.createFieldValue(caze);
    caze.getFieldValues.add(fve6)

    val fve7 = fdn7Saved.createFieldValue(caze);
    caze.getFieldValues.add(fve7)

    em.persist(fve1)
    em.persist(fve2)
    em.persist(fve3)
    em.persist(fve4)
    em.persist(fve6)
    em.persist(fve7)

    caze.setCaseStatus(CaseStatus.UNDER_PREPARATION)
    caze.setCaseDecisionType(CaseDecisionType.APPLICATION_APPROVAL)

  }
}
