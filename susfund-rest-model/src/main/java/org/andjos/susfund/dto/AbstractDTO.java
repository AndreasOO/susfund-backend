package org.andjos.susfund.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public abstract class AbstractDTO {

    @JsonbProperty("dtoClass")
    private String dtoClass;

    public AbstractDTO(String dtoClass){
        this.dtoClass = dtoClass;
    }

    public String getDtoClass() {
        return dtoClass;
    }

    public void setDtoClass(String dtoClass) {
        this.dtoClass = dtoClass;
    }
}
