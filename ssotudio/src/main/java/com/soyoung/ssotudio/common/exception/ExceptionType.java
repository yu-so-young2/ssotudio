package com.soyoung.ssotudio.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface ExceptionType {
    int getCode();
    String getMessage();
}
