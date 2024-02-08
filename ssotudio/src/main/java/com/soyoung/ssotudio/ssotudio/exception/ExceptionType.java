package com.soyoung.ssotudio.ssotudio.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType implements com.soyoung.ssotudio.common.exception.ExceptionType {
    INVALID_JSON_FORMAT(400, "유효한 JSON 형식이 아닙니다."),
    COLUMNS_NOT_FOUND(400, "'columns' object is missing"),
    FORM_FIELD_TYPE_NOT_FOUND(404, "존재하지 않는 Field Type 입니다."),
    FIELD_FILE_NOT_FOUND(400, "서버에 Field.json 파일이 존재하지 않습니다.");

    private final int code;
    private final String message;
}
