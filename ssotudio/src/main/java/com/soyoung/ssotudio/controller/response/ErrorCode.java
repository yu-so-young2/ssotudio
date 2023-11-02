package com.soyoung.ssotudio.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_JSON_FORMAT(400, "유효한 JSON 형식이 아닙니다.");

    private final int code;
    private final String message;
}
