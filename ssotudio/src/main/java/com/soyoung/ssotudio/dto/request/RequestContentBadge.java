package com.soyoung.ssotudio.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.soyoung.ssotudio.domain.Badge.ContentBadge;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestContentBadge {
    private String key;
    private List<ContentBadge.BadgeValue> values;

    @Builder
    public RequestContentBadge(String key, List<ContentBadge.BadgeValue> values) {
        this.key = key;
        this.values = values;
    }
}

