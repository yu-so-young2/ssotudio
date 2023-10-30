package com.soyoung.ssotudio.domain.Badge;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class ContentBadge {
    private String key;
    private ContentType type;
    private List<BadgeValue> values;

    @Builder
    public ContentBadge(String key, ContentType type, List<BadgeValue> values) {
        this.key = key;
        this.type = type;
        this.values = values;
    }

    @Data
    @NoArgsConstructor
    public static class BadgeValue {
        private Object value; // String, Boolean 모두 가능
        private String label;
        private String color;
        private String variant;

        @Builder
        public BadgeValue(Object value, String label, String color, String variant) {
            this.value = value;
            this.label = label;
            this.color = color;
            this.variant = variant;
        }
    }


}

