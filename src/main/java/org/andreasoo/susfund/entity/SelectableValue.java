package org.andreasoo.susfund.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class SelectableValue {

    @Id
    Long id;

    String selectableType;


    String value;
}
