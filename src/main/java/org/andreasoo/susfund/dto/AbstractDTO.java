package org.andreasoo.susfund.dto;

public abstract class AbstractDTO {

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
