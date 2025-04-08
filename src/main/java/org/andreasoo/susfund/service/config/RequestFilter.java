package org.andreasoo.susfund.service.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.andreasoo.susfund.service.KeyManager;

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
        if (path.equals("/auth/login")) {
            return;
        }

        String authHeader = requestContext.getHeaders().getFirst("Authorization");

        System.out.println("HEADER: " + authHeader);

        if(authHeader == null ||authHeader.isEmpty()) {
            abortWithUnauthorized(requestContext, "Toker header missing");
        }


        try{
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authHeader).getBody();

        }
        catch(ExpiredJwtException e){
            abortWithUnauthorized(requestContext, "Expired token");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
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
