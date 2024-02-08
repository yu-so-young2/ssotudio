package com.soyoung.ssotudio.ssotudio.dto.field;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SelectOption {
    private String label;
    private String value;
}
