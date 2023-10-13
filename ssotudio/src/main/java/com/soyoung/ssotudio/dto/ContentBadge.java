package com.soyoung.ssotudio.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentBadge {
    private String key;
    private String type;
    private List<BadgeValue> values;

    @Getter
    @Setter
    @Builder
    public static class BadgeValue {
        private Object value; // String, Boolean 모두 가능
        private String label;
        private String color;
        private String variant;
    }


}

