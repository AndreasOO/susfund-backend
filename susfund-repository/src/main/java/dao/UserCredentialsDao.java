package dao;

import entity.appuser.UserCredentials;
import util.LoginRequest;

import java.util.Optional;

public interface UserCredentialsDao {
    Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest);
}
