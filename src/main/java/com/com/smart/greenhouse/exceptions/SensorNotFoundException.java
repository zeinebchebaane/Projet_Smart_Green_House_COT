package com.com.smart.greenhouse.exceptions;


public class SensorNotFoundException extends  RuntimeException{
    String  message  ;
    public  SensorNotFoundException(String msg){
        super(msg);
        this.message=msg;
    }
}