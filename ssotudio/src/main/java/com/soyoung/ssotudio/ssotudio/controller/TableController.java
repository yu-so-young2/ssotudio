package com.soyoung.ssotudio.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.common.response.BasicResponse;
import com.soyoung.ssotudio.common.response.ResultType;
import com.soyoung.ssotudio.ssotudio.dto.Json;
import com.soyoung.ssotudio.common.response.SuccessData;
import com.soyoung.ssotudio.ssotudio.service.TableService;
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
    public ResponseEntity<BasicResponse<SuccessData>> getColumns(@RequestBody Json jsonDto) throws JsonProcessingException  {
        log.info("getColumns()");
        String jsonString = tableService.makeColumns(jsonDto);
        SuccessData data = SuccessData.builder().data(jsonString).build();
        BasicResponse<SuccessData> response = BasicResponse.of(ResultType.SUCCESS, null, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/cleaner")
    @Operation(summary = "테이블 클리너", description = "사용하지 않는 column 정보를 삭제합니다.")
    public ResponseEntity<BasicResponse<SuccessData>> cleanColumns(@RequestBody Json jsonDto) throws JsonProcessingException {
        log.info("cleanColumns()");
        String jsonString = tableService.cleanColumns(jsonDto);
        SuccessData data = SuccessData.builder().data(jsonString).build();
        BasicResponse<SuccessData> response = BasicResponse.of(ResultType.SUCCESS, null, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
