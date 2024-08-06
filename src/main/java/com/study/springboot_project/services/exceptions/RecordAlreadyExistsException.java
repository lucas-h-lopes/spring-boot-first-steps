package com.study.springboot_project.services.exceptions;

public class RecordAlreadyExistsException extends RuntimeException{
    public RecordAlreadyExistsException(String error){
        super(error);
    }
}
