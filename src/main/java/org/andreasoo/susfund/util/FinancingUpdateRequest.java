package org.andreasoo.susfund.util;

import org.andreasoo.susfund.entity.Financing;

import java.util.List;

public class FinancingUpdateRequest {

    List<Financing> financing;

    public List<Financing> getFinancing() {
        return financing;
    }

    public void setFinancing(List<Financing> financing) {
        this.financing = financing;
    }
}
