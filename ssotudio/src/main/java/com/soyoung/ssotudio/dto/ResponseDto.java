package com.soyoung.ssotudio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ResponseDto {
    String resultType;
    Object error;
    Object success;
}