package com.com.smart.greenhouse.exceptions;

public class UserNotAuthorizedToCreateAccountException extends  RuntimeException{
    String message  ;
    public  UserNotAuthorizedToCreateAccountException(String msg){
        super(msg);
        this.message=msg;
    }

}