package com.soyoung.ssotudio.controller.response;

import com.soyoung.ssotudio.exception.CustomException;
import lombok.Data;

import java.util.Map;

@Data
public class ErrorDetails {
    private int errorType;
    private int errorCode;
    private String reason;
    private Map<String, Object> data;
    private String title;

    private ErrorDetails(){

    }

    public static ErrorDetails of(CustomException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode(e.getExceptionType().getCode());
        errorDetails.setReason(e.getExceptionType().getMessage());
        return errorDetails;
    }
}
