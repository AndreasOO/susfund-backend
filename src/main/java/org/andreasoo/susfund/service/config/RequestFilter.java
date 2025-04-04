package org.andreasoo.susfund.service.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.nio.charset.StandardCharsets;

@Provider
public class RequestFilter implements ContainerRequestFilter {

    // hur tusan gör man med key?
    private static final String SECRET_KEY = "secretKey";

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String authHeader = requestContext.getHeaders().getFirst("Authorization");

        if(authHeader == null ||authHeader.isEmpty()) {
            Response response = Response.status(Response.Status.UNAUTHORIZED).type(MediaType.TEXT_PLAIN_TYPE).entity("Token header missing").build();
            requestContext.abortWith(response);
        }

        try{

            // parseClaimsJws försöker tolka token och verifierar signaturen
            Claims claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8)).build().parseClaimsJws(authHeader).getBody();

            // om man vill kunna läsa av olika properties till ContainerRequestContext-obj i resource-klass behöver man sätta dem från claims-obj här
            requestContext.setProperty("username", claims.getSubject());
            requestContext.setProperty("role", claims.get("role", String.class));
        }
        catch(ExpiredJwtException e){
            abortWithUnauthorized(requestContext, "Expired token");
        }
        catch (Exception e){
            abortWithUnauthorized(requestContext, "Invalid token");
        }
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext, String message) {
        Response response = Response.status(Response.Status.UNAUTHORIZED)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity(message)
                .build();
        requestContext.abortWith(response);
    }
}
