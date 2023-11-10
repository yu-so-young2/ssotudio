package com.soyoung.ssotudio.domain.Columns;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Columns {
    private List<String> order;
    private Map<String, Column> columns;


    @Getter
    @Setter
    @Builder
    public static class Column {
        private String label;
        private List<Content> contents;

        @Getter
        @Setter
        @Builder
        public static class Content {
            private String key;
            private String type;
        }
    }

}

