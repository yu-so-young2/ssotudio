package com.soyoung.ssotudio.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private ExceptionType exceptionType;

    public CustomException(ExceptionType exceptionType){
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
