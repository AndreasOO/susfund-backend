package org.andjos.susfund.entity.field.value;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.andjos.susfund.entity.caseentity.CaseEntity;
import org.andjos.susfund.entity.field.definition.FieldDefinition;


@Entity
@Table(name="field_value_entity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR_FIELD_VALUE_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractFieldValue <T extends FieldDefinition> {

    public AbstractFieldValue() {
    }

    public AbstractFieldValue(CaseEntity owningCase) {
        this.owningCase = owningCase;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="owning_case")
    CaseEntity owningCase;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="field_definition_entity_id")
    private FieldDefinition owningFieldDefinition;

    public T getFieldDefinition() {
        return (T) owningFieldDefinition;
    }

    public void setOwningFieldDefinition(FieldDefinition fieldDefinition) {
        this.owningFieldDefinition = fieldDefinition;
    }

    public abstract String getValueAsString();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaseEntity getOwningCase() {
        return owningCase;
    }

    public void setOwningCase(CaseEntity owningCase) {
        this.owningCase = owningCase;
    }

//    public void setOwningFieldDefinition(FieldDefinition owningFieldDefinition) {
//        this.owningFieldDefinition = owningFieldDefinition;
//    }
}
