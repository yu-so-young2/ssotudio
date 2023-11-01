package com.soyoung.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;

import com.soyoung.ssotudio.dto.request.JsonDto;
import com.soyoung.ssotudio.service.TableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/table")
public class TableController {

    private final TableService tableService;

    @PostMapping("/columns")
    public ResponseEntity getColumns(@RequestBody JsonDto jsonDto) throws JsonProcessingException, ParseException {
        log.info("getColumns()");

        String jsonString = tableService.makeColumns(jsonDto);

        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, jsonString);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
