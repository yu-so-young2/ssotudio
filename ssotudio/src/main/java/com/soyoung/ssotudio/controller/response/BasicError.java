package com.soyoung.ssotudio.controller.response;

import lombok.Data;

@Data
public class BasicError {
    private ErrorType errorType;
    private ErrorCode errorCode;
    private String reason;
    private ErrorData data;
}
