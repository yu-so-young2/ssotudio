package com.soyoung.ssotudio.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    private String key;
    private String type = "badge";
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

