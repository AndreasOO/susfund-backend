package org.andreasoo.susfund.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.andreasoo.susfund.dao.UserCredentialsDao;
import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.service.LoginService;
import org.andreasoo.susfund.util.LoginRequest;

import java.util.Optional;

@ApplicationScoped
public class LoginServiceImpl implements LoginService {

    @Inject
    UserCredentialsDao userCredentialsDao;

    @Override
    public Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest) {
        return userCredentialsDao.getUserCredentials(loginRequest);
    }
}
