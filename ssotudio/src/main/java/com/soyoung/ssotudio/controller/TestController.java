package com.soyoung.ssotudio.controller;

import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.response.EnumDto;
import com.soyoung.ssotudio.exception.CustomException;
import com.soyoung.ssotudio.exception.ExceptionType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/fail")
    @Operation(summary = "실패", description = "")
    public ResponseEntity<BasicResponse<String>> fail()  {

        throw new CustomException(ExceptionType.FORM_FIELD_TYPE_NOT_FOUND);
    }

    @GetMapping("/")
    @Operation(summary = "테스트")
    public ResponseEntity<List<EnumDto>> test(@RequestParam(required = false) String param1, @RequestParam(required = false) String param2) {
        List<EnumDto> enumList = new ArrayList<>();

        if("고기".equals(param1)) {
            enumList.add(EnumDto.builder().label("삼겹살").value("삼겹살").build());
            enumList.add(EnumDto.builder().label("갈비").value("갈비").build());
        }
        else if("밥".equals(param1)) {
            enumList.add(EnumDto.builder().label("비빔밥").value("비빔밥").build());
            enumList.add(EnumDto.builder().label("김치볶음밥").value("김치볶음밥").build());
        }

        if("매운거".equals(param2)) {
            enumList.add(EnumDto.builder().label("떡볶이").value("떡볶이").build());
            enumList.add(EnumDto.builder().label("마라탕").value("마라탕").build());
        }
        else if("안매운거".equals(param2)) {
            enumList.add(EnumDto.builder().label("샤브샤브").value("샤브샤브").build());
            enumList.add(EnumDto.builder().label("돌솥밥").value("돌솥밥").build());
        }
        
        return new ResponseEntity<>(enumList, HttpStatus.OK);
    }

}
