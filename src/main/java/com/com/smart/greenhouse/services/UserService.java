package com.com.smart.greenhouse.services;

import com.com.smart.greenhouse.Util.Argon2Utility;
import com.com.smart.greenhouse.exceptions.SensorNotFoundException;
import com.com.smart.greenhouse.exceptions.UserAlreadyExistsException;
import com.com.smart.greenhouse.exceptions.UserNotAuthorizedException;
import com.com.smart.greenhouse.exceptions.UserNotFoundException;
import com.com.smart.greenhouse.models.Role;
import com.com.smart.greenhouse.models.Sensor;
import com.com.smart.greenhouse.models.SensorType;
import com.com.smart.greenhouse.models.User;
import com.com.smart.greenhouse.repository.SensorRepository;
import com.com.smart.greenhouse.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;
    @Inject
    private SensorRepository sensorRepository;
    @Inject
    Argon2Utility argon2Utility ;


    public User createUser(User user) {
        if (user.getRoles().contains(Role.USER)) {
            throw new UserNotAuthorizedException();
        }
        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail() + " is already exists");
        }

        user.updatePassword(user.getPassword(),argon2Utility);
        return userRepository.save(user);
    }
    public User addUser(User user)  {
        if(userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException(user.getEmail() +" already exists") ;
        }
        user.updatePassword(user.getPassword(),argon2Utility);
        return userRepository.save(user) ;

    }

    public void delete(String email)  {
        if(!userRepository.findById(email).isPresent()){
            throw new UserNotFoundException("there is  no user with email :"+email) ;
        }
        userRepository.deleteById(email);

    }
    public Sensor findSensorById(String sensorId) throws SensorNotFoundException {
        if(!sensorRepository.findById(SensorType.valueOf(sensorId)).isPresent()){
            throw new SensorNotFoundException("there is no  sensor with such id "+sensorId);
        }
        return  sensorRepository.findById(SensorType.valueOf(sensorId)).get();
    }
}