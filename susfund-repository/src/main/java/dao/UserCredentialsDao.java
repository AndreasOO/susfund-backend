package dao;

import entity.appuser.UserCredentials;
import org.andreasoo.susfund.util.LoginRequest;

import java.util.Optional;

public interface UserCredentialsDao {
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
}
