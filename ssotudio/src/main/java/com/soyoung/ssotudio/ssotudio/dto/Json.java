package com.soyoung.ssotudio.ssotudio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Json {
    public String object;

    @Builder
    public Json(String object) {
        this.object = object;
    }

}
