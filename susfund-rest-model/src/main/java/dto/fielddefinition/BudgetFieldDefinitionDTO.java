package dto.fielddefinition;

import entity.field.definition.budget.BudgetType;
import entity.field.definition.fieldtype.FieldType;
import entity.field.definition.location.FrontendLocation;
import entity.field.definition.section.Section;
import entity.field.definition.section.SubSection;

public class BudgetFieldDefinitionDTO extends FieldDefinitionDTO {

    private BudgetType budgetType;

    public BudgetFieldDefinitionDTO(){}

    public BudgetFieldDefinitionDTO(BudgetType budgetType) {
        this.budgetType = budgetType;
    }

    public BudgetFieldDefinitionDTO(Long id, String title, String preamble, String assistingText, Boolean hasComment, Section section, SubSection subSection, FieldType fieldType, FrontendLocation frontendLocation, Long rowIndex, BudgetType budgetType) {
        super(id, title, preamble, assistingText, hasComment, section, subSection, fieldType, frontendLocation, rowIndex);
        this.setDtoClass("budgetFieldDefinition");
        this.budgetType = budgetType;
    }

    public BudgetType getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(BudgetType budgetType) {
        this.budgetType = budgetType;
    }
}
