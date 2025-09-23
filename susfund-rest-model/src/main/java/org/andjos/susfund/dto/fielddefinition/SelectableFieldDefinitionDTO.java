package org.andjos.susfund.dto.fielddefinition;

import org.andjos.susfund.dto.fieldvalue.SelectableValueDTO;
import org.andjos.susfund.entity.field.definition.fieldtype.FieldType;
import org.andjos.susfund.entity.field.definition.location.FrontendLocation;
import org.andjos.susfund.entity.field.definition.section.Section;
import org.andjos.susfund.entity.field.definition.section.SubSection;

import java.util.Set;

public class SelectableFieldDefinitionDTO extends FieldDefinitionDTO {

    private Set<SelectableValueDTO> selectableValues;

    public SelectableFieldDefinitionDTO(){}

    public SelectableFieldDefinitionDTO(Set<SelectableValueDTO> selectableValues) {
        this.selectableValues = selectableValues;
    }

    public SelectableFieldDefinitionDTO(Long id, String title, String preamble, String assistingText, Boolean hasComment, Section section, SubSection subSection, FieldType fieldType, FrontendLocation frontendLocation, Long rowIndex, Set<SelectableValueDTO> selectableValues) {
        super(id, title, preamble, assistingText, hasComment, section, subSection, fieldType, frontendLocation, rowIndex);
        this.setDtoClass("selectableFieldDefinition");
        this.selectableValues = selectableValues;
    }

    public Set<SelectableValueDTO> getSelectableValues() {
        return selectableValues;
    }

    public void setSelectableValues(Set<SelectableValueDTO> selectableValues) {
        this.selectableValues = selectableValues;
    }
}
