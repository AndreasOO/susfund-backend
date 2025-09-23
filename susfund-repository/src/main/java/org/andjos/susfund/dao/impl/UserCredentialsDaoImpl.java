package org.andjos.susfund.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.andjos.susfund.dao.UserCredentialsDao;
import org.andjos.susfund.entity.appuser.UserCredentials;
import org.andjos.susfund.util.LoginRequest;

import java.util.Optional;

@ApplicationScoped
public class UserCredentialsDaoImpl implements UserCredentialsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest){
        try {
            TypedQuery<UserCredentials> query = entityManager.createQuery(
                    "SELECT user FROM UserCredentials user WHERE user.username = :username", UserCredentials.class);
            query.setParameter("username", loginRequest.getUsername());

            UserCredentials user = query.getSingleResult();
            if (loginRequest.getPassword().equals(user.getUserPassword().getPassword())) {
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        }
        catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
