package org.andreasoo.susfund.dto;

import jakarta.persistence.Column;

public class SupportTypeNodeDTO extends AbstractDTO {

    private Long id;
    private String techName;

    public SupportTypeNodeDTO() {
        super("supportTypeNode");

    }

    public SupportTypeNodeDTO(Long id, String techName) {
        super("supportTypeNode");
        this.id = id;
        this.techName = techName;
    }

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

}
