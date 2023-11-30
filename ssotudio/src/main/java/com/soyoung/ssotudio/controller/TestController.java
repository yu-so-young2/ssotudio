package com.soyoung.ssotudio.controller;

import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Test", description = "테스트 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {


    @GetMapping("/success/without-data")
    @Operation(summary = "데이터 없는 성공", description = "success/data = null 응답")
    public ResponseEntity<BasicResponse<String>> successWithoutData()  {
    
        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
