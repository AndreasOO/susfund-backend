package org.andreasoo.susfund.dto.fielddefinition;

import org.andreasoo.susfund.entity.updated.field.definition.budget.BudgetType;
import org.andreasoo.susfund.entity.updated.field.definition.fieldtype.FieldType;
import org.andreasoo.susfund.entity.updated.field.definition.location.FrontendLocation;
import org.andreasoo.susfund.entity.updated.field.definition.section.Section;
import org.andreasoo.susfund.entity.updated.field.definition.section.SubSection;

public class BudgetFieldDefinitionDTO extends FieldDefinitionDTO {

    private BudgetType budgetType;

    public BudgetFieldDefinitionDTO(){}

    public BudgetFieldDefinitionDTO(BudgetType budgetType) {
        this.budgetType = budgetType;
    }

    public BudgetFieldDefinitionDTO(Long id, String title, String preamble, String assistingText, Boolean hasComment, Section section, SubSection subSection, FieldType fieldType, FrontendLocation frontendLocation, Long rowIndex, BudgetType budgetType) {
        super(id, title, preamble, assistingText, hasComment, section, subSection, fieldType, frontendLocation, rowIndex);
        this.budgetType = budgetType;
    }

    public BudgetType getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(BudgetType budgetType) {
        this.budgetType = budgetType;
    }
}
