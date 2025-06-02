package org.andreasoo.susfund.controller;

import io.jsonwebtoken.Jwts;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.controller.config.KeyManager;
import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.service.LoginService;
import org.andreasoo.susfund.util.LoginRequest;
import org.andreasoo.susfund.util.TokenBearer;


import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;

@Path("/auth")
public class LoginResource {

    private final Key key = KeyManager.getSigningKey();

    @Inject
    LoginService loginService;

    public LoginResource() throws NoSuchAlgorithmException {
    }

//    @Path("/login")
//    @PUT
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response login(LoginRequest loginRequest) {
//        Optional<UserCredentials> result = loginService.getUserCredentials(loginRequest);
//        if (result.isEmpty()){
//            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
//        }
//        String jwt = generateToken(result.get());
//        return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt).build();
//    }

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

    @Path("/login")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(LoginRequest loginRequest) {

        Optional<UserCredentials> result = loginService.getUserCredentials(loginRequest);

        if (result.isEmpty()){
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }
        TokenBearer token = new TokenBearer();
        token.setToken(generateToken(result.get()));

        Response response = Response.ok(token).build();
        response.getHeaders().add("token", token.getToken());
        return response;
    }
}
