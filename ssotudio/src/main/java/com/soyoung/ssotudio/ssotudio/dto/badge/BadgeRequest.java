package com.soyoung.ssotudio.ssotudio.dto.badge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgeRequest {
    private String key;
    private List<Badge.BadgeValue> values;

    @Builder
    public BadgeRequest(String key, List<Badge.BadgeValue> values) {
        this.key = key;
        this.values = values;
    }
}

