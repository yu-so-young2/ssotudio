package com.soyoung.ssotudio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ApiResponse {
    private String resultType;
    private ErrorDetails error;
    private SuccessDetails success;

    @Builder
    @Setter
    @Getter
    public class ErrorDetails {
        private String code;
        private String message;
    }

    @Builder
    @Setter
    @Getter
    public class SuccessDetails {
        private Object result;
    }

}