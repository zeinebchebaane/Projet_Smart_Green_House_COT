package com.com.smart.greenhouse.security.exceptions;

public class UserNotAuthorizedException extends  RuntimeException{
    String message  ;
    public  UserNotAuthorizedException (String msg){
        super(msg);
        this.message=msg;
    }

}