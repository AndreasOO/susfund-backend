package org.andreasoo.susfund.service;

import io.jsonwebtoken.Jwts;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.entity.UserCredentials;


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

    @POST
    @Path("/login")
    public Response login(String username, String password) {

        TypedQuery<UserCredentials> query = entityManager.createQuery(
                "SELECT u FROM UserCredentials u WHERE u.username = :username", UserCredentials.class);
        query.setParameter("username", username);

        UserCredentials user;
        try {
            user = query.getSingleResult();
        }
        catch (NoResultException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }

        if(!password.equals(user.getUserPassword().getPassword())) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }

        String token = generateToken(user);
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
