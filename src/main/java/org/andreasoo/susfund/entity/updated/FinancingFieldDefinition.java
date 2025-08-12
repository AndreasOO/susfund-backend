package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value="FINANCING")
public class FinancingFieldDefinition extends FieldDefinition {

    @Column(name="financing_type")
    @Enumerated(EnumType.STRING)
    FinancingType2 financingType;

}
