package com.soyoung.ssotudio.common.exception;

import com.soyoung.ssotudio.common.exception.ExceptionType;
import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private ExceptionType exceptionType;

    public CustomException(ExceptionType exceptionType){
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
