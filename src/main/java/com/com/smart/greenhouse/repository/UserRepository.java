package com.com.smart.greenhouse.repository;


import com.com.smart.greenhouse.models.User;
import jakarta.nosql.mapping.Repository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends Repository<User,String> {
    static Optional<User> findByEmail(String email) {
        return null;
    }

    List<User> findAll() ;

}
