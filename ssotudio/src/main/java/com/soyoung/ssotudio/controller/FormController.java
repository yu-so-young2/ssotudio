package com.soyoung.ssotudio.controller;

import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.response.EnumDto;
import com.soyoung.ssotudio.service.FormService;
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
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/form")
public class FormController {

    private final FormService formService;

    @GetMapping("/types")
    public ResponseEntity<List<EnumDto>> getFormFieldTypes() throws IOException {
        log.info("getFormFieldTypes()");

        List<EnumDto> formFieldTypes = formService.getFormFieldTypes();

        return new ResponseEntity(formFieldTypes, HttpStatus.OK);
    }

    @GetMapping("/format")
    public ResponseEntity<BasicResponse<String>> getFormFieldDefaultFormat(@RequestParam("type") String type) throws IOException {
        log.info("getFormFieldDefaultFormat() : "+type);

//        String fieldDefaultFormat = formService.getFormFieldDefaultFormat(type);
        String fieldDefaultFormat = formService.getFormFieldDefaultFormat(type);

        BasicResponse<String> response = BasicResponse.of(ResultType.SUCCESS, null, fieldDefaultFormat);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}