package com.soyoung.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.request.RequestContentButton;
import com.soyoung.ssotudio.service.ButtonService;
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
@Tag(name = "Button", description = "버튼 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ButtonController {

    private final ButtonService buttonService;

    @PostMapping("/button")
    @Operation(summary = "버튼 생성", description = "label, targetContainer에 해당하는 버튼 content를 생성합니다.")
    public ResponseEntity<BasicResponse<String>> makeButton(@RequestBody RequestContentButton requestContentButton) throws JsonProcessingException {
        log.info("makeButton()");
        String jsonString = buttonService.makeButton(requestContentButton);

        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, jsonString);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
