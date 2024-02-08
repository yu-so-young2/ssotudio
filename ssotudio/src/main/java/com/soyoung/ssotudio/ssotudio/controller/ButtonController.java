package com.soyoung.ssotudio.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.common.response.BasicResponse;
import com.soyoung.ssotudio.common.response.ResultType;
import com.soyoung.ssotudio.ssotudio.dto.button.ButtonRequest;
import com.soyoung.ssotudio.common.response.SuccessData;
import com.soyoung.ssotudio.ssotudio.service.ButtonService;
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
    public ResponseEntity<BasicResponse<SuccessData>> makeButton(@RequestBody ButtonRequest requestContentButton) throws JsonProcessingException {
        log.info("makeButton()");
        String jsonString = buttonService.makeButton(requestContentButton);
        SuccessData data = SuccessData.builder().data(jsonString).build();
        BasicResponse<SuccessData> response = BasicResponse.of(ResultType.SUCCESS, null, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
