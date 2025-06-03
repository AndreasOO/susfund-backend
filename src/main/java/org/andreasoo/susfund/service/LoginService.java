package org.andreasoo.susfund.service;

import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.util.LoginRequest;
import org.andreasoo.susfund.util.TokenBearer;

import java.util.Optional;

public interface LoginService {
    String generateToken(UserCredentials user);
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
    Optional<TokenBearer> handleLogin(LoginRequest loginRequest);
}
