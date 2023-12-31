package com.soyoung.ssotudio.controller.response;

import lombok.Data;

@Data
public class BasicResponse<T> {
    private ResultType resultType;
    private ErrorDetails error;
    private T data;

    private BasicResponse() {
    }

    public static <T> BasicResponse<T> of(ResultType resultType, ErrorDetails error, T success) {
        BasicResponse<T> basicResponse = new BasicResponse<>();
        basicResponse.setResultType(resultType);
        basicResponse.setError(error);
        basicResponse.setData(success);

        return basicResponse;
    }
 }
