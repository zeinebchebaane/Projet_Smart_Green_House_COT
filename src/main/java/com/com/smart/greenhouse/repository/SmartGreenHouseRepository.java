package com.com.smart.greenhouse.repository;

import com.com.smart.greenhouse.models.SmartGreenHouse;
import jakarta.nosql.mapping.Repository;

import java.util.Set;

public interface SmartGreenHouseRepository extends Repository<SmartGreenHouse,String> {
        Set<SmartGreenHouse> findAll()  ;
        Set<SmartGreenHouse> findByUserName(String username) ;
        }
