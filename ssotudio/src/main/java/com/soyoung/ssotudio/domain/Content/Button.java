package com.soyoung.ssotudio.domain.Content;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Button {
    private ContentType type;
    private String value;
    private String color;
    private String variant;
    private TargetContainer targetContainer;

    @Builder
    public Button(ContentType type, String value, String color, String variant, TargetContainer targetContainer) {
        this.type = type;
        this.value = value;
        this.color = color;
        this.variant = variant;
        this.targetContainer = targetContainer;
    }

    @Data
    @NoArgsConstructor
    public static class TargetContainer {
        private String type;
        private String codeName;
        private Map<String, Param> params;

        @Builder
        public TargetContainer(String type, String codeName, Map<String, Param> params) {
            this.type = type;
            this.codeName = codeName;
            this.params = params;
        }

        @Data
        @NoArgsConstructor
        public static class Param {
            private String key;

            @Builder
            public Param(String key) {
                this.key = key;
            }
        }
    }


}

