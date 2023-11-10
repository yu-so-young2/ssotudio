package com.soyoung.ssotudio.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnumDto {
    private String label;
    private String value;
}
