package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.domain.Badge.ContentBadge;
import com.soyoung.ssotudio.dto.RequestContentBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BadgeServiceTest {

    @Autowired
    BadgeService badgeService;

    @Test
    @DisplayName("bade를 생성한다.")
    void BadgeServiceTest() throws JsonProcessingException {
        // given
        ContentBadge.BadgeValue badgeValue = ContentBadge.BadgeValue.builder()
                .color("green")
                .value(true)
                .variant("weak")
                .label("Y")
                .build();

        String key = "isVisited";
        RequestContentBadge badge = new RequestContentBadge(key, List.of(badgeValue));

        // when
        String result = badgeService.makeBadges(badge);

        // then
        assertThat(result).isEqualTo("{\n" +
                "  \"key\" : \"isVisited\",\n" +
                "  \"type\" : \"badge\",\n" +
                "  \"values\" : [\n" +
                "    {\n" +
                "      \"value\" : true,\n" +
                "      \"label\" : \"Y\",\n" +
                "      \"color\" : \"green\",\n" +
                "      \"variant\" : \"weak\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }
}