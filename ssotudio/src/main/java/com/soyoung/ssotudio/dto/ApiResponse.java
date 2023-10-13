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

    @Setter
    @Getter
    @Builder
    public static class ErrorDetails {
        private String code;
        private String message;
    }

    @Setter
    @Getter
    @Builder
    public static class SuccessDetails {
        private Object result;
    }

}