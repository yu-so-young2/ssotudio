package com.soyoung.ssotudio.test.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chiikawa {
    private Integer id;
    private String image;
    private String name;
    private String html;
}
