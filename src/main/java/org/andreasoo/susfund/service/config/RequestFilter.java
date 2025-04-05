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
import java.security.Key;
import java.security.NoSuchAlgorithmException;

@Provider
public class RequestFilter implements ContainerRequestFilter {

    private final Key key = KeyManager.getSigningKey();

    public RequestFilter() throws NoSuchAlgorithmException {
    }

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String path = requestContext.getUriInfo().getPath();
        if (path.equals("login")) {
            return;
        }

        String authHeader = requestContext.getHeaders().getFirst("Authorization");

        if(authHeader == null ||authHeader.isEmpty()) {
            abortWithUnauthorized(requestContext, "Toker header missing");
        }

        try{
            // parseClaimsJws försöker tolka token och verifierar signaturen
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authHeader).getBody();

            requestContext.setProperty("username", claims.getSubject());
            requestContext.setProperty("roles", claims.get("roles", String.class));
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
