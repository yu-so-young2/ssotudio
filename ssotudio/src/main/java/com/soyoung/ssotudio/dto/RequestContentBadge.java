package com.soyoung.ssotudio.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestContentBadge {
    private String key;
    private List<ContentBadge.BadgeValue> values;

    @Builder
    public RequestContentBadge(String key, List<ContentBadge.BadgeValue> values) {
        this.key = key;
        this.values = values;
    }
}

