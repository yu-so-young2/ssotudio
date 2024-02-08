package com.soyoung.ssotudio.test.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType implements com.soyoung.ssotudio.common.exception.ExceptionType {
    CHIIKAWA_FILE_NOT_FOUND(400, "서버에 Chiikawa.json 파일이 존재하지 않습니다."),
    CHIIKAWA_ID_NOT_FOUND(404, "존재하지 않는 Chiikawa 입니다.");

    private final int code;
    private final String message;
}
