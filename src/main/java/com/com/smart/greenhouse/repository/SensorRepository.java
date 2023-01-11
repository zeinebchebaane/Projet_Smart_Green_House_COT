package com.com.smart.greenhouse.repository;

import com.com.smart.greenhouse.models.Sensor;
import com.com.smart.greenhouse.models.SensorType;
import jakarta.nosql.mapping.Repository;
import java.util.*;
import java.util.Optional;

public interface SensorRepository extends Repository<Sensor, SensorType> {
    Optional<Sensor> findByType(SensorType type);
    List <Sensor> findAll();
}