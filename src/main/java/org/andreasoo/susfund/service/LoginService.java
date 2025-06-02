package org.andreasoo.susfund.service;

import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.util.LoginRequest;

import java.util.Optional;

public interface LoginService {
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
}
