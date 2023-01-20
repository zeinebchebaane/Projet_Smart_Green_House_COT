package com.com.smart.greenhouse.boundaries;

import com.com.smart.greenhouse.exceptions.SensorNotFoundException;
import com.com.smart.greenhouse.exceptions.UserAlreadyExistsException;
import com.com.smart.greenhouse.exceptions.UserNotFoundException;
import com.com.smart.greenhouse.filters.Secured;
import com.com.smart.greenhouse.models.User;
import com.com.smart.greenhouse.repository.UserRepository;
import com.com.smart.greenhouse.services.UserService;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@ApplicationScoped
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResources {

    @Inject
    private UserService userService;
    @Inject
    private UserRepository repository;

    @POST
    @Path("/signup")
    public Response createUser(@Valid User user) {

        try {
            if (repository.findById(user.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("User " + user.getEmail() + " already exist.");
            }
            return Response.ok(userService.createUser(user)).build();
        } catch (UserAlreadyExistsException e) {
            return Response.status(400, e.getMessage()).build();
        }
    }
    @POST()
    @Path("user/add")
    @Secured
    @RolesAllowed("ADMIN")
    public  Response addUser( @Valid User user){
        try {
            return Response.ok(userService.addUser(user).getUsername()).build();
        } catch(UserAlreadyExistsException e) {
            return Response.status(400 , e.getMessage()).build() ;
        }
    }
    @DELETE()
    @Path("user/{email}")
    @RolesAllowed("ADMIN")
    public  Response deleteUser(@PathParam("email") String email){
        try {
            userService.delete(email);
            return  Response.ok().build() ;
        }catch(UserNotFoundException e){
            return  Response.status(400 , e.getMessage()).build() ;
        }

    }
    @GET
    @Path("/user/sensor/{id}")
    @RolesAllowed({"ADMIN","USER"})

    public  Response getSensor(@PathParam(("id")) String id  ) {
        try {
            return Response.ok(userService.findSensorById(id)).build();
        } catch (SensorNotFoundException exception) {
            return Response.status(400, exception.getMessage()).build();
        }

    }

}
