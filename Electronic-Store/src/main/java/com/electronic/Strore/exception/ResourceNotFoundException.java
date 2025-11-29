package com.electronic.Strore.exception;

import lombok.Builder;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not Found");
    }
    @Builder
    public ResourceNotFoundException(String message){
        super(message);
    }


}
