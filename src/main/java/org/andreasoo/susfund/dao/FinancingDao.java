package org.andreasoo.susfund.dao;

import jakarta.transaction.Transactional;

public interface FinancingDao {

    @Transactional
    boolean updateFinancingById(int id, int newEstimatedFinancingPercentage, int newEstimatedFinancingMoney);
}
