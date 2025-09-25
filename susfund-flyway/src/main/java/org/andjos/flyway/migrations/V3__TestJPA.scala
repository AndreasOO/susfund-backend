package org.andjos.flyway.migrations

import jakarta.persistence.EntityManager
import org.andjos.flyway.base.JPAMigrationBase
import org.andjos.susfund.entity.caseentity.CaseEntity
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

    val stn:SupportTypeNode = em.createQuery("SELECT stn FROM SupportTypeNode stn WHERE stn.techName = :techName",
        classOf[SupportTypeNode])
      .setParameter("techName","FTG/2022/REGIONAL_INVESTMENT/INFRASTRUCTURE")
      .getSingleResult
    stn.getFieldDefinitions.add(fdn1Saved)

    em.persist(stn)


    val caze:CaseEntity = em.createQuery("SELECT ce FROM CaseEntity ce where ce.id= :id",
      classOf[CaseEntity])
      .setParameter("id", 1)
      .getSingleResult

    val fve = fdn1Saved.createFieldValue(caze)
    caze.getFieldValues.add(fve)

    em.persist(fve)

  }
}
