package com.demo.rest;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;

@Path("/")
@ApplicationScoped
public class RootResource {
    @RolesAllowed("ROLE")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response get() {
        return Response.ok("Check your cookies!")
                .cookie(new NewCookie.Builder("some-cookie")
                        .value("some-value")
                        .path("/")
                        .build())
                .build();
    }
}
