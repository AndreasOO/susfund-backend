package org.andreasoo.susfund.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.andreasoo.susfund.entity.UserCredentials;
import org.andreasoo.susfund.entity.UserPassword;

@Path("/auth")
public class AuthenticationResource {

    @PersistenceContext
    private EntityManager entityManager;

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
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        // kolla om angivna lösenordet är samma som i user-objektet
        if(!password.equals(user.getUserPassword().getPassword())) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok().build();
    }
}
