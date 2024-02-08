package com.soyoung.ssotudio.ssotudio.dto.button;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ButtonRequest {
    private String value;
    private String color;
    private String variant;
    private TargetContainer targetContainer;

    @Builder
    public ButtonRequest(String value, String color, String variant, TargetContainer targetContainer) {
        this.value = value;
        this.color = color;
        this.variant = variant;
        this.targetContainer = targetContainer;
    }

    @Data
    @NoArgsConstructor
    public static class TargetContainer {
        private String codeName;
        private String type;
        private List<Param> params;

        @Builder
        public TargetContainer(String codeName, String type, List<Param> params) {
            this.codeName = codeName;
            this.type = type;
            this.params = params;
        }

        @Data
        @NoArgsConstructor
        public static class Param {
            private String originKey;
            private String transferKey;

            @Builder
            public Param(String originKey, String transferKey) {
                this.originKey = originKey;
                this.transferKey = transferKey;
            }
        }

    }

}

