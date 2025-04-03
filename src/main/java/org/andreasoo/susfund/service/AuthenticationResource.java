package org.andreasoo.susfund.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.entity.UserPassword;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Path("/auth")
public class AuthenticationResource {

    @PersistenceContext
    private EntityManager entityManager;

    SecretKey key = Keys.hmacShaKeyFor("secretKey".getBytes(StandardCharsets.UTF_8));

    // ta in rätt parametrar
    @POST
    @Path("/login")
    public Response login(String username, String password) {

        // för att hämta användaren från databasen
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

        // kolla om angivna lösenordet är samma som i user-objektet
        if(!password.equals(user.getUserPassword().getPassword())) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }


        // vad ska returneras? token?
        String token = generateToken(user);
        return Response.ok().entity(token).build();
    }

    // Skapa upp token som kan returneras till klienten som gjort anropet, som klienten kan användas framtida requests
    public String generateToken(UserCredentials user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // expiration 1 timme
                .signWith(key)
                .compact();
    }
}
