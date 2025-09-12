package service;

import entity.appuser.UserCredentials;
import util.LoginRequest;
import util.TokenBearer;

import java.util.Optional;

public interface LoginService {
    String generateToken(UserCredentials user);
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
    Optional<TokenBearer> handleLogin(LoginRequest loginRequest);
}
