package org.andjos.susfund.service;

import common.util.LoginRequest;
import common.util.TokenBearer;
import org.andjos.susfund.entity.appuser.UserCredentials;
import java.util.Optional;

public interface LoginService {
    String generateToken(UserCredentials user);
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
    Optional<TokenBearer> handleLogin(LoginRequest loginRequest);
}
