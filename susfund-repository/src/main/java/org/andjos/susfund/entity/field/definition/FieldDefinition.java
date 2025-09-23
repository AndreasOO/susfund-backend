package org.andjos.susfund.entity.field.definition;

import jakarta.persistence.*;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.field.definition.fieldtype.FieldType;
import org.andjos.susfund.entity.field.definition.location.FrontendLocation;
import org.andjos.susfund.entity.field.definition.section.Section;
import org.andjos.susfund.entity.field.definition.section.SubSection;
import org.andjos.susfund.entity.field.value.AbstractFieldValue;
import org.andjos.susfund.entity.field.value.assessment.AssessmentFieldValue;
import org.andjos.susfund.entity.field.value.budget.BudgetFieldValue;
import org.andjos.susfund.entity.field.value.datefield.DateFieldValue;
import org.andjos.susfund.entity.field.value.decision.DecisionFieldValue;
import org.andjos.susfund.entity.field.value.history.HistoryLogFieldValue;
import org.andjos.susfund.entity.field.value.numericfield.NumericFieldValue;
import org.andjos.susfund.entity.field.value.textfield.TextFieldValue;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR_FIELD_TYPE")
@DiscriminatorValue(value="SIMPLE_FIELD_DEFINITION")
@Table(name="field_definition_entity")
public class FieldDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String preamble;

    @Column(name="assisting_text")
    private String assistingText;

    @Column(name="has_comment")
    boolean hasComment;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Section section;

    @Column(name="sub_section")
    @Enumerated(EnumType.STRING)
    private SubSection subSection;

    @Column(name="field_type")
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;

    @Column(name="frontend_location")
    @Enumerated(EnumType.STRING)
    private FrontendLocation frontendLocation;

    @Column(name="row_index")
    private Long rowIndex;


    public AbstractFieldValue<? extends FieldDefinition> createFieldValue(CaseEntity caseEntity) {
        AbstractFieldValue<? extends FieldDefinition> fieldValue=  switch (fieldType) {
            case TEXT_FIELD -> new TextFieldValue(caseEntity);
            case NUMERIC_FIELD -> new NumericFieldValue(caseEntity);
            case DATE_FIELD -> new DateFieldValue(caseEntity);
            case DECISION -> new DecisionFieldValue(caseEntity);
            case BUDGET -> new BudgetFieldValue(caseEntity);
            case APPLICATION_QUESTION -> new TextFieldValue(caseEntity);
            case ASSESSMENT_QUESTION -> new AssessmentFieldValue(caseEntity);
            case HISTORY_LOG -> new HistoryLogFieldValue(caseEntity);
        };

        fieldValue.setOwningFieldDefinition(this);
        return fieldValue;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }

    public String getAssistingText() {
        return assistingText;
    }

    public void setAssistingText(String assistingText) {
        this.assistingText = assistingText;
    }

    public boolean isHasComment() {
        return hasComment;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public SubSection getSubSection() {
        return subSection;
    }

    public void setSubSection(SubSection subSection) {
        this.subSection = subSection;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public FrontendLocation getFrontendLocation() {
        return frontendLocation;
    }

    public void setFrontendLocation(FrontendLocation frontendLocation) {
        this.frontendLocation = frontendLocation;
    }

    public Long getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Long rowIndex) {
        this.rowIndex = rowIndex;
    }
}
