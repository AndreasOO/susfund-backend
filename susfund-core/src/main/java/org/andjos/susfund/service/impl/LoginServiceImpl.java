package org.andjos.susfund.service.impl;

import io.jsonwebtoken.Jwts;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.andjos.susfund.dao.UserCredentialsDao;
import org.andjos.susfund.entity.appuser.UserCredentials;
import org.andjos.susfund.service.LoginService;
import common.util.TokenBearer;
import common.util.LoginRequest;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;
import common.util.KeyManager;

@ApplicationScoped
public class LoginServiceImpl implements LoginService {

    public LoginServiceImpl() throws NoSuchAlgorithmException {
    }

    private final Key key = KeyManager.getSigningKey();


    @Inject
    UserCredentialsDao userCredentialsDao;

    @Override
    public String generateToken(UserCredentials user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .claim("roles", user.getUserRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000))
                .signWith(key)
                .compact();
    }

    @Override
    public Optional<UserCredentials> getUserCredentials(LoginRequest loginRequest) {
        return userCredentialsDao.getUserCredentials(loginRequest);
    }

    @Override
    public Optional<TokenBearer> handleLogin(LoginRequest loginRequest) {
        Optional<UserCredentials> user = getUserCredentials(loginRequest);

        if (user.isEmpty()){
            return Optional.empty();
        } else {
            TokenBearer token = new TokenBearer();
            token.setToken(generateToken(user.get()));
            return Optional.of(token);
        }
    }
}
