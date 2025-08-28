package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR_FIELD_TYPE")
@DiscriminatorValue(value="SIMPLE_FIELD_DEFINITION")
@Table(name="field_definition_entity")
public class FieldDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    private String section;

    @Column(name="field_type")
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;

    @Column(name="frontend_location")
    @Enumerated(EnumType.STRING)
    private FrontendLocation frontendLocation;

    @Column(name="row_index")
    private Long rowIndex;


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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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
