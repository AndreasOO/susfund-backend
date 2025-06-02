package org.andreasoo.susfund.controller;

import io.jsonwebtoken.Jwts;

import jakarta.ejb.Stateless;
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

@Stateless
@Path("/auth")
public class LoginResource {

    @Inject
    LoginService loginService;



    @Path("/login")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(LoginRequest loginRequest) {

        Optional<TokenBearer> token = loginService.handleLogin(loginRequest);

        if (token.isPresent()) {
            return Response.ok(token).header("token",token.get().getToken()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }

    }
}
