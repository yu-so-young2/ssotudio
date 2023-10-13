package com.soyoung.ssotudio.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestContentBadge {
    private String key;
    private List<ContentBadge.BadgeValue> values;
}

