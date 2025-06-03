package org.andreasoo.susfund.dao;

import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.util.LoginRequest;

import java.util.Optional;

public interface UserCredentialsDao {
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
}
