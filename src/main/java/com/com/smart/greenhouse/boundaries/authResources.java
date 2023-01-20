package com.com.smart.greenhouse.boundaries;


import com.com.smart.greenhouse.security.authRequest;
import com.com.smart.greenhouse.security.authResponse;
import com.com.smart.greenhouse.security.authService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@ApplicationScoped
@Path("oauth2")
public class authResources {

    @Inject
    private authService service;


    @POST
    @Path("token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public authResponse token(  authRequest request) {
        switch (request.getGrandType()) {

            case PASSWORD:
                return service.token(request);
            case REFRESH_TOKEN:
                return service.refreshToken(request);
            default:
                throw new UnsupportedOperationException("There is not support to another type");
        }
    }
}