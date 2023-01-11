package com.com.smart.greenhouse.controllers;
import com.com.smart.greenhouse.models.User;
import com.com.smart.greenhouse.security.exceptions.UserAlreadyExistsException;
import com.com.smart.greenhouse.security.exceptions.UserNotAuthorizedException;
import com.com.smart.greenhouse.services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@ApplicationScoped
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResources {

    @Inject
    private UserService userService ;

    @POST
    @Path("/signup")
    public Response createUser(@Valid User user){

        try {
            return Response.ok(userService.createUser(user)).build() ;
        } catch (UserAlreadyExistsException  e){
            return  Response.status(400, e.getMessage()).build();
        }catch (UserNotAuthorizedException exception){
            return  Response.status(400  ,exception.getMessage()).build();
        }
    }

    }