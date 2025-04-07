package org.andreasoo.susfund.service;

import io.jsonwebtoken.Jwts;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.util.LoginRequest;
import org.andreasoo.susfund.util.TokenBearer;


import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Path("/auth")
public class AuthenticationResource {

    @PersistenceContext
    private EntityManager entityManager;

    private final Key key = KeyManager.getSigningKey();

    public AuthenticationResource() throws NoSuchAlgorithmException {
    }

    @Path("/login")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(LoginRequest loginRequest) {

        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        TypedQuery<UserCredentials> query = entityManager.createQuery(
                "SELECT u FROM UserCredentials u WHERE u.username = :username", UserCredentials.class);
        query.setParameter("username", loginRequest.getUsername());

        UserCredentials user;
        try {
            user = query.getSingleResult();
            System.out.println("From obj: " + user.getUserPassword().getPassword());
        }
        catch (NoResultException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }

        if(!loginRequest.getPassword().equals(user.getUserPassword().getPassword())) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }

        TokenBearer token = new TokenBearer();
        token.setToken(generateToken(user));
        return Response.ok().entity(token).build();
    }

    public String generateToken(UserCredentials user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .claim("roles", user.getUserRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 timme
                .signWith(key)
                .compact();
    }
}
