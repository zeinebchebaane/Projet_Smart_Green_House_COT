package com.com.smart.greenhouse.services;

import com.com.smart.greenhouse.models.Role;
import com.com.smart.greenhouse.models.User;
import com.com.smart.greenhouse.repository.SensorRepository;
import com.com.smart.greenhouse.repository.UserRepository;
import com.com.smart.greenhouse.security.exceptions.UserAlreadyExistsException;
import com.com.smart.greenhouse.security.exceptions.UserNotAuthorizedException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;
    @Inject
    private SensorRepository sensorRepository ;
    public User createUser(User user){
        if( user.getRoles().contains(Role.USER)){
            throw new UserNotAuthorizedException("Only the  admin can create users accounts") ;
        }
        if(userRepository.findById(user.getEmail()).isPresent()){
            throw  new UserAlreadyExistsException(user.getEmail()+" is already exists") ;
        }
        return  userRepository.save(user) ;
    }


}