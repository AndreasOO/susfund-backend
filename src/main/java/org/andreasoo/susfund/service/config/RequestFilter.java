package org.andreasoo.susfund.service.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RequestFilter implements ContainerRequestFilter {

    // hur tusan gör man med key?
    private static final String SECRET_KEY = "secretKey";

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String token = requestContext.getHeaders().getFirst("Authentication");

        try{
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody();

            // om man vill kunna läsa av olika properties till ContainerRequestContext-obj i resource-klass behöver man sätta dem från claims-obj här
            requestContext.setProperty("username", claims.getSubject());
            requestContext.setProperty("role", claims.get("role", String.class));
        }
        catch(SignatureException e){
            Response response = Response.status(Response.Status.UNAUTHORIZED).type(MediaType.TEXT_PLAIN_TYPE).entity("Token header invalid").build();
            requestContext.abortWith(response);
        }
    }
}
