package org.andreasoo.susfund.entity.updated.supporttype;

import jakarta.persistence.*;
import org.andreasoo.susfund.entity.updated.field.definition.FieldDefinition;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="support_type_node")
public class SupportTypeNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="tech_name")
    private String techName;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch =  FetchType.LAZY)
    @JoinTable(
            name="stn_fdn",
            joinColumns = {@JoinColumn(name="support_type_node_id")},
            inverseJoinColumns = {@JoinColumn(name="field_definition_id")}
    )
    private List<FieldDefinition> fieldDefinitions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public List<FieldDefinition> getFieldDefinitions() {
        return fieldDefinitions;
    }

    public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
        this.fieldDefinitions = fieldDefinitions;
    }
}
