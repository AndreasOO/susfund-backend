package org.andjos.susfund.dao;

import org.andjos.susfund.entity.appuser.UserCredentials;
import org.andjos.susfund.util.LoginRequest;

import java.util.Optional;

public interface UserCredentialsDao {
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
}
