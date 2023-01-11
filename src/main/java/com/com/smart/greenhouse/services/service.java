package com.com.smart.greenhouse.services;

import com.com.smart.greenhouse.models.User;
import com.com.smart.greenhouse.security.exceptions.UserAlreadyExistsException;

public interface service {

    User createUser(User user) throws UserAlreadyExistsException;
    User addUser(User user) throws  UserAlreadyExistsException  ;

}
