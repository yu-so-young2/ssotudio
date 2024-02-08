package com.soyoung.ssotudio.controller;

import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.response.DataDto;
import com.soyoung.ssotudio.dto.response.EnumDto;
import com.soyoung.ssotudio.service.FormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@Tag(name = "Form", description = "폼 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/form")
public class FormController {

    private final FormService formService;

    @GetMapping("/types")
    @Operation(summary = "폼 필드 목록 조회")
    public ResponseEntity<List<EnumDto>> getFormFieldTypes() throws IOException {
        log.info("getFormFieldTypes()");

        List<EnumDto> formFieldTypes = formService.getFormFieldTypes();

        return new ResponseEntity(formFieldTypes, HttpStatus.OK);
    }

    @GetMapping("/format")
    @Operation(summary = "폼 필드 생성", description = "type에 해당하는 폼 필드의 기본 format을 조회합니다.")
    public ResponseEntity<BasicResponse<DataDto>> getFormFieldDefaultFormat(@RequestParam("type") String type) throws IOException {
        log.info("getFormFieldDefaultFormat() : "+type);

        String fieldDefaultFormat = formService.getFormFieldDefaultFormat(type);

        DataDto data = DataDto.builder().data(fieldDefaultFormat).build();
        BasicResponse<DataDto> response = BasicResponse.of(ResultType.SUCCESS, null, data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}