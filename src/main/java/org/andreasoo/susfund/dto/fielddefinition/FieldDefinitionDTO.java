package org.andreasoo.susfund.dto.fielddefinition;

import org.andreasoo.susfund.dto.AbstractDTO;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.field.definition.location.FrontendLocation;
import org.andreasoo.susfund.entity.updated.field.definition.section.Section;
import org.andreasoo.susfund.entity.updated.field.definition.section.SubSection;

public class FieldDefinitionDTO extends AbstractDTO {

    private Long id;
    private String title;
    private String preamble;
    private String assistingText;
    private Boolean hasComment;
    private Section section;
    private SubSection subSection;
    private FieldType fieldType;
    private FrontendLocation frontendLocation;
    private Long rowIndex;

    public FieldDefinitionDTO() {
        super("fieldDefinition");
    }

    public FieldDefinitionDTO(Long id, String title, String preamble, String assistingText,
                              Boolean hasComment, Section section, SubSection subSection,
                              FieldType fieldType, FrontendLocation frontendLocation, Long rowIndex) {
        super("fieldDefinition");
        this.id = id;
        this.title = title;
        this.preamble = preamble;
        this.assistingText = assistingText;
        this.hasComment = hasComment;
        this.section = section;
        this.subSection = subSection;
        this.fieldType = fieldType;
        this.frontendLocation = frontendLocation;
        this.rowIndex = rowIndex;
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

    public Boolean getHasComment() {
        return hasComment;
    }

    public void setHasComment(Boolean hasComment) {
        this.hasComment = hasComment;
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
