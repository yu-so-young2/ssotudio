package com.soyoung.ssotudio.controller.response;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private ErrorType errorType;
    private ErrorCode errorCode;
    private String reason;
    private ErrorData data;

    public CustomException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
