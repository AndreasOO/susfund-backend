package org.andjos.susfund.dto;

public class SupportTypeNodeDTO  {

    private Long id;
    private String techName;

    public SupportTypeNodeDTO() {


    }

    public SupportTypeNodeDTO(Long id, String techName) {
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
