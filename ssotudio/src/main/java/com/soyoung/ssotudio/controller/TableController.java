package com.soyoung.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.request.JsonDto;
import com.soyoung.ssotudio.service.TableService;
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
@Tag(name = "Table", description = "테이블 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/table")
public class TableController {

    private final TableService tableService;

    @PostMapping("/columns")
    @Operation(summary = "테이블 생성", description = "응답값에 해당하는 테이블 columns를 생성합니다.")
    public ResponseEntity<BasicResponse<String>> getColumns(@RequestBody JsonDto jsonDto) throws JsonProcessingException  {
        log.info("getColumns()");

        String jsonString = tableService.makeColumns(jsonDto);

        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, jsonString);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/cleaner")
    @Operation(summary = "테이블 클리너", description = "사용하지 않는 column 정보를 삭제합니다.")
    public ResponseEntity<BasicResponse<String>> cleanColumns(@RequestBody JsonDto jsonDto) throws JsonProcessingException {
        log.info("cleanColumns()");

        String jsonString = tableService.cleanColumns(jsonDto);

        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, jsonString);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
