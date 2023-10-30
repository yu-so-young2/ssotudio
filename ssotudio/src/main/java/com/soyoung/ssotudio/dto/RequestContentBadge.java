package com.soyoung.ssotudio.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
public class RequestContentBadge {
    private String key;
    private List<ContentBadge.BadgeValue> values;
}

