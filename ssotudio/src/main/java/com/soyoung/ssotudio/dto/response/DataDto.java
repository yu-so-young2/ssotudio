package com.soyoung.ssotudio.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataDto<T> {
    private T data;
}
