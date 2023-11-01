package com.soyoung.ssotudio.dto.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonDto {
    public String object;

    @Builder
    public JsonDto(String object) {
        this.object = object;
    }

}
