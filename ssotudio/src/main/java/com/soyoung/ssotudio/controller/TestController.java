package com.soyoung.ssotudio.controller;

import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.response.EnumDto;
import com.soyoung.ssotudio.exception.CustomException;
import com.soyoung.ssotudio.exception.ExceptionType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Data;
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

    @GetMapping("/1")
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

    @GetMapping("/2")
    @Operation(summary = "sourceKey 테스트")
    public ResponseEntity<BasicResponse<List<Transaction>>> test2() {

        SourceId sourceId1 = SourceId.builder().sourceId("SOURCE_1").build();
        SourceId sourceId2 = SourceId.builder().sourceId("SOURCE_2").build();
        SourceId sourceId3 = SourceId.builder().sourceId("SOURCE_3").build();
        List<SourceId> sourceIds1 = new ArrayList<>();
        sourceIds1.add(sourceId1);
        sourceIds1.add(sourceId2);
        List<SourceId> sourceIds2 = new ArrayList<>();
        sourceIds2.add(sourceId1);
        sourceIds2.add(sourceId3);
        SubTransaction subTransaction1 = SubTransaction.builder().subId(1).sourceIds(sourceIds1).build();
        SubTransaction subTransaction2 = SubTransaction.builder().subId(2).sourceIds(sourceIds2).build();
        List<SubTransaction> subTransactions1 = new ArrayList<>();
        subTransactions1.add(subTransaction1);
        subTransactions1.add(subTransaction2);
        Transaction transaction1 = Transaction.builder().transactions(subTransactions1).build();

        SourceId sourceId4 = SourceId.builder().sourceId("SOURCE_4").build();
        SourceId sourceId5 = SourceId.builder().sourceId("SOURCE_5").build();
        SourceId sourceId6 = SourceId.builder().sourceId("SOURCE_6").build();
        List<SourceId> sourceIds3 = new ArrayList<>();
        sourceIds3.add(sourceId1);
        sourceIds3.add(sourceId2);
        sourceIds3.add(sourceId3);
        sourceIds3.add(sourceId6);
        List<SourceId> sourceIds4 = new ArrayList<>();
        sourceIds4.add(sourceId4);
        sourceIds4.add(sourceId5);
        sourceIds4.add(sourceId5);
        SubTransaction subTransaction3 = SubTransaction.builder().subId(3).sourceIds(sourceIds3).build();
        SubTransaction subTransaction4 = SubTransaction.builder().subId(4).sourceIds(sourceIds4).build();
        List<SubTransaction> subTransactions2 = new ArrayList<>();
        subTransactions2.add(subTransaction3);
        subTransactions2.add(subTransaction4);
        Transaction transaction2 = Transaction.builder().transactions(subTransactions2).build();


        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        BasicResponse<List<Transaction>> response = BasicResponse.of(ResultType.SUCCESS, null, transactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Data
    @Builder
    static class Transaction {
        private int id;
        private List<SubTransaction> transactions;
    }

    @Data
    @Builder
    static class SubTransaction {
        private int subId;
        private List<SourceId> sourceIds;
    }

    @Data
    @Builder
    static class SourceId {
        private String sourceId;
    }
}
