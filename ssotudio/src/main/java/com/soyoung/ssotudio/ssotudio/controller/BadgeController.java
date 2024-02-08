package com.soyoung.ssotudio.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.common.response.BasicResponse;
import com.soyoung.ssotudio.common.response.ResultType;
import com.soyoung.ssotudio.ssotudio.dto.badge.BadgeRequest;
import com.soyoung.ssotudio.common.response.SuccessData;
import com.soyoung.ssotudio.ssotudio.service.BadgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Badge", description = "뱃지 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BadgeController {

    private final BadgeService badgeService;

    @PostMapping("/badges")
    @Operation(summary = "뱃지 생성", description = "key, value, label에 해당하는 뱃지 content를 생성합니다.")
    public ResponseEntity<BasicResponse<SuccessData>> makeBadge(@RequestBody BadgeRequest requestContentBadge) throws JsonProcessingException {
        log.info("makeBadge()");
        String jsonString = badgeService.makeBadge(requestContentBadge);
        SuccessData data = SuccessData.builder().data(jsonString).build();
        BasicResponse<SuccessData> response = BasicResponse.of(ResultType.SUCCESS, null, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
