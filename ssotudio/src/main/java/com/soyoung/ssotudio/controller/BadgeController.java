package com.soyoung.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.request.RequestContentBadge;
import com.soyoung.ssotudio.service.BadgeService;
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
    public ResponseEntity<BasicResponse<String>> getBadges(@RequestBody RequestContentBadge requestContentBadge) throws JsonProcessingException {
        log.info("getBadges()");
        String jsonString = badgeService.makeBadges(requestContentBadge);

        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, jsonString);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
