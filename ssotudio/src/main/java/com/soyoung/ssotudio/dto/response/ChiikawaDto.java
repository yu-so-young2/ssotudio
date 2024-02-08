package com.soyoung.ssotudio.dto.response;

import lombok.Builder;
import lombok.Data;

import javax.swing.text.html.HTML;

@Data
@Builder
public class ChiikawaDto {
    private Integer id;
    private String image;
    private String name;
    private String html;
}
