package com.soyoung.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.controller.response.BasicResponse;
import com.soyoung.ssotudio.controller.response.ResultType;
import com.soyoung.ssotudio.dto.request.RequestContentBadge;
import com.soyoung.ssotudio.dto.response.ChiikawaDto;
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

import javax.swing.text.html.HTML;
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

    @GetMapping("/chiikawa")
    @Operation(summary = "석환님 메롱", description = "")
    public ResponseEntity<BasicResponse<List<ChiikawaDto>>> getChiikawaList() {
        List<ChiikawaDto> chiikawaDtos = new ArrayList<>();
        ChiikawaDto chiikawaDto3 = ChiikawaDto.builder()
                .id(3)
                .image("https://i.namu.wiki/i/EqejW1MYM4pbZiWoKWTTV_cFNNoHXH_Voz6qNMt9D0nVTJezg94dSdb0l6JTwLFLrmUM8UWU5ySngRLH2_PVEA.webp")
                .html("<h2>Input Button</h2>\n" +
                        "\n" +
                        "<input type=\"button\" onclick=\"alert('Hello World!')\" value=\"Click Me!\">")
                .name("랏코")
                .build();


        ChiikawaDto chiikawaDto2 = ChiikawaDto.builder()
                .id(2)
                .image("<img src=\"https://i.namu.wiki/i/geGngQMnvmK2g3wuKU4O1uNs8Ix1HXQULk9PrnT57lHOlU4AxL9qsNCYXOOY9DIqPWtXnphq8G6NzCcvzv-ppQ.webp\" alt=\"\" width=\"200\" height=\"200\">")
                .html("<h2>An Ordered HTML List</h2>\n" +
                "\n" +
                "<ol>\n" +
                "  <li>Coffee</li>\n" +
                "  <li>Tea</li>\n" +
                "  <li>Milk</li>\n" +
                "</ol> ")
                .name("우사기")
                .build();

        ChiikawaDto chiikawaDto1 = ChiikawaDto.builder()
                .id(1)
                .image("<img src=\"https://i.namu.wiki/i/Yu5BDHQYknKmChLkS9bgOR0jqfE3ojWF_VgjMJ3nhbmztCFy_qp8pFs0eN4q7sM8FYnCU8Nv89wAPcBPMXo3Sg.webp\" alt=\"\" width=\"200\" height=\"200\">")
                .html("<div style=\"position:relative;\">\n" +
                "  <div style=\"opacity:0.3;position:absolute;left:120px;top:20px;width:100px;height:170px;background-color:#73AD21\"></div>\n" +
                "  <div style=\"margin-top:30px;width:360px;height:130px;padding:20px;border-radius:10px;border:10px solid #EE872A;font-size:120%;\">\n" +
                "    <h1>CSS = Styles and Colors</h1>\n" +
                "    <div style=\"letter-spacing:12px;font-size:15px;position:relative;left:25px;top:25px;\">Manipulate Text</div>\n" +
                "    <div style=\"color:#40B3DF;letter-spacing:12px;font-size:15px;position:relative;left:25px;top:30px;\">Colors,\n" +
                "    <span style=\"background-color:#B4009E;color:#ffffff;\"> Boxes</span></div>\n" +
                "  </div>\n" +
                "</div>")
                .name("치이카와")
                .build();
        chiikawaDtos.add(chiikawaDto1);
        chiikawaDtos.add(chiikawaDto2);
        chiikawaDtos.add(chiikawaDto3);

        BasicResponse<List<ChiikawaDto>> response = BasicResponse.of(ResultType.SUCCESS, null, chiikawaDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/chiikawa/{id}")
    @Operation(summary = "석환님 메롱", description = "")
    public ResponseEntity<BasicResponse<ChiikawaDto>> getChiikawa(@PathVariable("id") int id)  {
        ChiikawaDto chiikawaDto2 = ChiikawaDto.builder()
                .id(2)
                .image("<img src=\"https://i.namu.wiki/i/geGngQMnvmK2g3wuKU4O1uNs8Ix1HXQULk9PrnT57lHOlU4AxL9qsNCYXOOY9DIqPWtXnphq8G6NzCcvzv-ppQ.webp\" alt=\"\" width=\"200\" height=\"200\">")
                .html("<h2>An Ordered HTML List</h2>\n" +
                        "\n" +
                        "<ol>\n" +
                        "  <li>Coffee</li>\n" +
                        "  <li>Tea</li>\n" +
                        "  <li>Milk</li>\n" +
                        "</ol> ")
                .name("우사기")
                .build();

        ChiikawaDto chiikawaDto1 = ChiikawaDto.builder()
                .id(1)
                .image("<img src=\"https://i.namu.wiki/i/Yu5BDHQYknKmChLkS9bgOR0jqfE3ojWF_VgjMJ3nhbmztCFy_qp8pFs0eN4q7sM8FYnCU8Nv89wAPcBPMXo3Sg.webp\" alt=\"\" width=\"200\" height=\"200\">")
                .html("<div style=\"position:relative;\">\n" +
                        "  <div style=\"opacity:0.3;position:absolute;left:120px;top:20px;width:100px;height:170px;background-color:#73AD21\"></div>\n" +
                        "  <div style=\"margin-top:30px;width:360px;height:130px;padding:20px;border-radius:10px;border:10px solid #EE872A;font-size:120%;\">\n" +
                        "    <h1>CSS = Styles and Colors</h1>\n" +
                        "    <div style=\"letter-spacing:12px;font-size:15px;position:relative;left:25px;top:25px;\">Manipulate Text</div>\n" +
                        "    <div style=\"color:#40B3DF;letter-spacing:12px;font-size:15px;position:relative;left:25px;top:30px;\">Colors,\n" +
                        "    <span style=\"background-color:#B4009E;color:#ffffff;\"> Boxes</span></div>\n" +
                        "  </div>\n" +
                        "</div>")
                .name("치이카와")
                .build();


        ChiikawaDto chiikawaDto3 = ChiikawaDto.builder()
                .id(3)
                .image("<img src=\"https://i.namu.wiki/i/EqejW1MYM4pbZiWoKWTTV_cFNNoHXH_Voz6qNMt9D0nVTJezg94dSdb0l6JTwLFLrmUM8UWU5ySngRLH2_PVEA.webp\" alt=\"\" width=\"200\" height=\"200\">")
                .html("<h2>Input Button</h2>\n" +
                        "\n" +
                        "<input type=\"button\" onclick=\"alert('Hello World!')\" value=\"Click Me!\">")
                .name("랏코")
                .build();


        ChiikawaDto chiikawa = null;
        if(id==1) {
            chiikawa = chiikawaDto1;
        } else if(id==2) {
            chiikawa = chiikawaDto2;
        } else if(id==3) {
            chiikawa = chiikawaDto3;
        }


        BasicResponse<ChiikawaDto> response = BasicResponse.of(ResultType.SUCCESS, null, chiikawa);
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
