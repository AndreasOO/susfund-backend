package org.andreasoo.susfund.dto;

public abstract class AbstractDTO {

    private final String dtoClass;

    public AbstractDTO(String dtoClass){
        this.dtoClass = dtoClass;
    }

    public String getDtoClass() {
        return dtoClass;
    }
}
