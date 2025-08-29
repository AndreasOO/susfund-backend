package org.andreasoo.susfund.entity.updated.field.value;


import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.CaseEntity;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;

@Entity
@Table(name="field_value_entity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR_FIELD_VALUE_TYPE")
public abstract class AbstractFieldValue <T extends FieldDefinition> {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owning_case")
    CaseEntity owningCase;

    @ManyToOne(fetch=FetchType.LAZY)
    private FieldDefinition owningFieldDefinition;

    public T getFieldDefinition() {
        return (T) owningFieldDefinition;
    }

    public abstract String getValueAsString();


}
