package org.andreasoo.susfund.entity.updated;

import jakarta.persistence.*;

@Entity
public class SelectableValue {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    Long id;

    @Column(name="selectable_type")
    @Enumerated(EnumType.STRING)
    SelectableType selectableType;

    String value;
}
