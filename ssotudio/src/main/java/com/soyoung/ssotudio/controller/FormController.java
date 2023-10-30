package com.soyoung.ssotudio.controller;

import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.domain.Field.Field;
import com.soyoung.ssotudio.dto.*;
import com.soyoung.ssotudio.service.FormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/form")
public class FormController {

    private final FormService formService;

    @GetMapping("/types")
    public ResponseEntity getFormFieldTypes() {
        log.info("getFormFieldTypes()");

        List<EnumDto> formFieldTypes = formService.getFormFieldTypes();

        BasicResponse<List<EnumDto>> response = BasicResponse.of(ResultType.SUCCESS, null, formFieldTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Deprecated
    @GetMapping("/format")
    public ResponseEntity getFormFieldDefaultFormat(@RequestParam("type") String type){
        log.info("getFormFieldDefaultFormat()");

        Field field = formService.getFormFieldDefaultFormat(type);


        BasicResponse<Field> response = BasicResponse.of(ResultType.SUCCESS, null, field);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
