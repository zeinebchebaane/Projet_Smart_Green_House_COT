package com.com.smart.greenhouse.security.exceptions;

public class UserAlreadyExistsException extends  RuntimeException{
    String message ;
    public UserAlreadyExistsException(String msg) {
        super(msg);
        this.message=msg ;
    }

}
