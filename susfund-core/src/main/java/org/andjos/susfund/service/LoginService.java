package org.andjos.susfund.service;

import org.andjos.susfund.util.LoginRequest;
import org.andjos.susfund.util.TokenBearer;
import org.andjos.susfund.entity.appuser.UserCredentials;
import java.util.Optional;

public interface LoginService {
    String generateToken(UserCredentials user);
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
    Optional<TokenBearer> handleLogin(LoginRequest loginRequest);
}
