package com.soyoung.ssotudio.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.soyoung.ssotudio.domain.Content.Badge;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestContentBadge {
    private String key;
    private List<Badge.BadgeValue> values;

    @Builder
    public RequestContentBadge(String key, List<Badge.BadgeValue> values) {
        this.key = key;
        this.values = values;
    }
}

