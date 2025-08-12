package org.andreasoo.susfund.entity;


import jakarta.persistence.*;

@Entity
@Table(name="field_value_entity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR_FIELD_VALUE_TYPE")

public abstract class AbstractFieldValue <T extends FieldDefinition> {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    Cases owningCase;


    @ManyToOne(fetch=FetchType.LAZY)
    private FieldDefinition owningFieldDefinition;

    public T getFieldDefinition() {
        return (T) owningFieldDefinition;
    }

    public abstract String getValueAsString();


}
