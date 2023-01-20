package com.com.smart.greenhouse.services;

import com.com.smart.greenhouse.exceptions.SensorNotFoundException;
import com.com.smart.greenhouse.exceptions.UserAlreadyExistsException;
import com.com.smart.greenhouse.exceptions.UserNotFoundException;
import com.com.smart.greenhouse.models.Sensor;
import com.com.smart.greenhouse.models.User;

public interface service {

    User createUser(User user) throws UserAlreadyExistsException;
    User addUser(User user) throws  UserAlreadyExistsException  ;
    void delete(String email) throws UserNotFoundException;
    Sensor findSensorById(String sensorId) throws SensorNotFoundException;

}
