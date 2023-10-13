package com.soyoung.ssotudio.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Columns {
    private Map<String, Column> columns;
    private List<String> order;
    private String json;

    @Getter
    @Setter
    @Builder
    static class Column {
        private String label;
        List<Content> contents;

        @Getter
        @Setter
        @Builder
        static class Content {
            private String key;
            private String type = "string";
        }
    }

}

