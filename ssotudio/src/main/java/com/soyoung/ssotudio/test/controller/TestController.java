package com.soyoung.ssotudio.test.controller;

import com.soyoung.ssotudio.common.exception.CustomException;
import com.soyoung.ssotudio.common.response.BasicResponse;
import com.soyoung.ssotudio.common.response.ResultType;
import com.soyoung.ssotudio.test.dto.Chiikawa;
import com.soyoung.ssotudio.ssotudio.dto.field.SelectOption;
import com.soyoung.ssotudio.ssotudio.exception.ExceptionType;
import com.soyoung.ssotudio.test.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Test", description = "테스트 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/response/success/without-data")
    @Operation(summary = "데이터 없는 성공", description = "success/data = null 응답")
    public ResponseEntity<BasicResponse<String>> successWithoutData()  {
        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/response/fail")
    @Operation(summary = "실패", description = "")
    public ResponseEntity<BasicResponse<String>> fail()  {
        throw new CustomException(ExceptionType.FORM_FIELD_TYPE_NOT_FOUND);
    }

    @GetMapping("/html")
    @Operation(summary = "html 응답 테이블", description = "")
    public ResponseEntity<BasicResponse<List<Chiikawa>>> getChiikawaList() {
        List<Chiikawa> chiikawaList = testService.getAllChiikawa();
        BasicResponse<List<Chiikawa>> response = BasicResponse.of(ResultType.SUCCESS, null, chiikawaList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/html/{id}")
    @Operation(summary = "html 응답 상세", description = "")
    public ResponseEntity<BasicResponse<Chiikawa>> getChiikawa(@PathVariable("id") String id) throws InterruptedException {
        Chiikawa chiikawa = testService.getChiikawa(id);
        Thread.sleep(1000);
        BasicResponse<Chiikawa> response = BasicResponse.of(ResultType.SUCCESS, null, chiikawa);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/action")
    @Operation(summary = "async select option 호출 테스트용 API")
    public ResponseEntity<List<SelectOption>> asyncSelectOption(@RequestParam(required = false) String param1, @RequestParam(required = false) String param2) {
        List<SelectOption> enumList = testService.getSelectOptions(param1, param2);
        return new ResponseEntity<>(enumList, HttpStatus.OK);
    }
}
