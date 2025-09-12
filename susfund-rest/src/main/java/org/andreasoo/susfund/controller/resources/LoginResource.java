package org.andreasoo.susfund.controller.resources;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.andjos.susfund.service.LoginService;
import common.util.TokenBearer;


import java.util.Optional;
import common.util.LoginRequest;

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
