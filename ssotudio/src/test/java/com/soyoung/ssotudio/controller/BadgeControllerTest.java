package com.soyoung.ssotudio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.ssotudio.dto.badge.Badge;
import com.soyoung.ssotudio.ssotudio.dto.badge.BadgeRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BadgeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    @Test
    @DisplayName("뱃지를 생성한다.")
    void BadgeControllerTest() throws Exception {
        // given
        Badge.BadgeValue badgeValue = Badge.BadgeValue.builder()
                .color("green")
                .value(true)
                .variant("weak")
                .label("Y")
                .build();
        String key = "isVisited";
        BadgeRequest badge = new BadgeRequest(key, List.of(badgeValue));

        // when // then
        mockMvc.perform(post("/api/badges")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(badge)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}