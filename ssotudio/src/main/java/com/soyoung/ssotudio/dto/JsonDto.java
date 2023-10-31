package com.soyoung.ssotudio.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonDto {
    public String object;
}
