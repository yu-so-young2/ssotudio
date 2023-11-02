package com.soyoung.ssotudio.exception;

import com.soyoung.ssotudio.controller.response.CustomException;
import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BasicResponse> customException(CustomException e) {
        BasicResponse<String> response = BasicResponse.of(ResultType.FAIL, e, null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
