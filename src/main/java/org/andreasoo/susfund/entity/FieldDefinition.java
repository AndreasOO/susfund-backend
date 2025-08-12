package org.andreasoo.susfund.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR_FIELD_TYPE")
@DiscriminatorValue(value="SIMPLE_FIELD_DEFINITION")
@Table(name="field_definition")
public class FieldDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String preamble;

    @Column(name="assisting_text")
    private String assistingText;

    @Column(name="field_type")
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;


    @Column(name="frontend_location")
    @Enumerated(EnumType.STRING)
    private FrontendLocation frontendLocation;

    @Column(name="has_comment")
    boolean hasComment;

    @Column(name="row_index")
    private Long rowIndex;
}
