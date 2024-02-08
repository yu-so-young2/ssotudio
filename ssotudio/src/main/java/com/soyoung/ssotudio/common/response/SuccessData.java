package com.soyoung.ssotudio.common.response;

import lombok.Builder;

@lombok.Data
@Builder
public class SuccessData<T> {
    private T data;
}
