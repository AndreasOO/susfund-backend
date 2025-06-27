package org.andreasoo.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.andreasoo.susfund.dao.FinancingDao;
import org.andreasoo.susfund.entity.Financing;

@ApplicationScoped
public class FinancingDaoImpl implements FinancingDao {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public boolean updateFinancingById(int id, int newEstimatedFinancingPercentage, int newEstimatedFinancingMoney) {
        try{
            Financing financing = entityManager.find(Financing.class, id);
            financing.setEstimatedFinancingInPercentage(newEstimatedFinancingPercentage);
            financing.setEstimatedFinancingInMoney(newEstimatedFinancingMoney);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
