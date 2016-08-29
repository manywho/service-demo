package com.manywho.services.demo.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/health")
@Produces(MediaType.TEXT_HTML)
public class HealthController {

    @GET
    public Response health() {
        return Response.ok().build();
    }
}
