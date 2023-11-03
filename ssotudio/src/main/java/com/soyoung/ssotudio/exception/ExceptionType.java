package com.soyoung.ssotudio.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {
    INVALID_JSON_FORMAT(400, "유효한 JSON 형식이 아닙니다."),
    FORM_FIELD_TYPE_NOT_FOUND(404, "존재하지 않는 Field Type 입니다.");

    private final int code;
    private final String message;
}
