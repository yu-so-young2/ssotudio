package com.soyoung.ssotudio.domain.Field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@RequiredArgsConstructor
public enum FieldType {
    alert("alert", "{\r\n   \"icon\":\"icon-warning-circle\",\r\n   \"size\":\"medium\",\r\n   \"type\":\"alert\",\r\n   \"theme\":\"yellow\",\r\n   \"value\":\"여기에 메시지를 입력하세요\"\r\n}"),
    async_description("async-description", "{\r\n   \"type\":\"async-description\",\r\n   \"value\":\"{{tag}}\",\r\n   \"onError\":{\r\n      \"type\":\"toast\",\r\n      \"message\":\"다시 시도해주세요.\"\r\n   },\r\n   \"actionName\":\"defaultCodeFill\"\r\n}"),
    async_image("async-image", "{\r\n   \"name\":\"image\",\r\n   \"type\":\"async-image\",\r\n   \"value\":\"data:image/png;base64,{{{image}}}\",\r\n   \"onError\":{\r\n      \"type\":\"toast\",\r\n      \"message\":\"다시 시도해주세요.\"\r\n   },\r\n   \"actionName\":\"idCardImage\"\r\n}"),
    border("border", "{\r\n   \"type\":\"border\",\r\n   \"theme\":\"default\"\r\n}"),
    checkbox("checkbox", "{\r\n   \"name\":\"본인체크\",\r\n   \"type\":\"checkbox\",\r\n   \"options\":[\r\n      \"고객 본인의 요청으로 진행하는 것을 확인했습니다.\"\r\n   ],\r\n   \"minLength\":1,\r\n   \"validationMessage\":{\r\n      \"empty\":\"내용을 확인하고 체크해주세요.\"\r\n   }\r\n}"),
    date("date", "{\r\n   \"name\":\"startDate\",\r\n   \"type\":\"date\",\r\n   \"label\":\"조회기간\",\r\n   \"dateFormat\":\"yyyy-MM-dd\",\r\n   \"placeholder\":\"YYYY-MM-dd\",\r\n   \"defaultValue\":\"0d\",\r\n   \"validationMessage\":{\r\n      \"empty\":\"조회기간을 입력해주세요.\"\r\n   },\r\n   \"serializeWithIsoFormat\":true\r\n}"),
    date_range("date-range", "{\r\n   \"name\":\"regTs\",\r\n   \"type\":\"date-range\",\r\n   \"label\":\"검색 기간\",\r\n   \"keyMap\":{\r\n      \"since\":\"startRegTs\",\r\n      \"until\":\"endRegTs\"\r\n   },\r\n   \"required\":\"both\",\r\n   \"dateFormat\":\"yyyy-MM-dd\",\r\n   \"placeholder\":\"YYYY-MM-DD\",\r\n   \"defaultValue\":\"1w\",\r\n   \"validationMessage\":{\r\n      \"empty\":\"조회기간을 입력해주세요.\"\r\n   },\r\n   \"serializeWithIsoFormat\":true\r\n}"),
    description("description", "{\r\n   \"type\":\"description\",\r\n   \"value\":\"<p style=\\\"font-size: 15px;color: rgb(107, 118, 132);\\\">디스크립션입니다.</p>\"\r\n}"),
    file("file", "{\r\n   \"name\":\"file\",\r\n   \"size\":200,\r\n   \"type\":\"file\",\r\n   \"label\":\"신분증 사진\",\r\n   \"required\":true,\r\n   \"bottomText\":\"최대 200KB의 파일만 업로드할 수 있어요.\",\r\n   \"extensions\":[\r\n      \".png\",\r\n      \".jpg\",\r\n      \".jpeg\",\r\n      \".gif\"\r\n   ],\r\n   \"placeholder\":\"파일 선택\",\r\n   \"validationMessage\":{\r\n      \"size\":\"최대 200KB의 파일만 업로드할 수 있어요.\",\r\n      \"empty\":\"파일을 첨부해주세요.\",\r\n      \"extensions\":\" 파일만 업로드할 수 있어요.\"\r\n   }\r\n}"),
    hidden_key("hidden (key)", "{\r\n   \"name\":\"name\",\r\n   \"type\":\"hidden\",\r\n   \"value\":{\r\n      \"type\":\"key\",\r\n      \"key\":\"name\"\r\n   }\r\n}"),
    hidden_template("hidden (template)", "{\r\n   \"name\":\"name\",\r\n   \"type\":\"hidden\",\r\n   \"value\":{\r\n      \"type\":\"template\",\r\n      \"template\":\"{{name}}\"\r\n   }\r\n}"),
    hidden_raw("hidden (raw)", "{\r\n   \"name\":\"name\",\r\n   \"type\":\"hidden\",\r\n   \"value\":{\r\n      \"type\":\"raw\",\r\n      \"content\":true\r\n\r\n   }\r\n}"),
    hstack("hstack", "{\r\n   \"type\":\"hstack\",\r\n   \"children\":[\r\n      \r\n   ],\r\n   \"fractions\":[\r\n      \"1fr\",\r\n      \"1fr\"\r\n   ]\r\n}"),
    number("number", "{\r\n   \"name\":\"interest\",\r\n   \"type\":\"number\",\r\n   \"label\":\"금리\",\r\n   \"defaultValue\":\"{{interest}}\"\r\n}"),
    link("link", "{\r\n   \"type\":\"link\",\r\n   \"value\":\"열기\",\r\n   \"targetContainer\":{\r\n      \"type\":\"리다이렉트\",\r\n      \"params\":{\r\n         \"gaNo\":{\r\n            \"key\":\"sendUserGaNo\"\r\n         }\r\n      },\r\n      \"codeName\":\"리다이렉트\"\r\n   }\r\n}"),
    list("list", "{\r\n   \"name\":\"listEx\",\r\n   \"type\":\"list\",\r\n   \"label\":\"리스트\",\r\n   \"subText\":\"Object를 리스트에 담아 보낼 수 있어요.\",\r\n   \"draggable\":true,\r\n   \"children\":[\r\n      \r\n   ]\r\n}"),
    password("password", "{\r\n   \"name\":\"password\",\r\n   \"type\":\"password\",\r\n   \"label\":\"비밀번호\",\r\n   \"placeholder\":\"비밀번호 입력\"\r\n}"),
    radio_async("radio (async)", "{\r\n   \"name\":\"valid\",\r\n   \"type\":\"radio\",\r\n   \"label\":\"적용여부\",\r\n   \"inline\":true,\r\n   \"options\":{\r\n      \"type\":\"async\",\r\n      \"keyMap\":{\r\n         \"label\":\"label\",\r\n         \"value\":\"value\"\r\n      },\r\n      \"actionName\":\"fetchBankList\",\r\n      \"requiredFields\":[\r\n         \r\n      ]\r\n   }\r\n}"),
    radio_pairs("radio (pairs)", "{\r\n   \"name\":\"valid\",\r\n   \"type\":\"radio\",\r\n   \"label\":\"적용여부\",\r\n   \"inline\":true,\r\n   \"options\":{\r\n      \"type\":\"pairs\",\r\n      \"values\":[\r\n         {\r\n            \"label\":\"적용\",\r\n            \"value\":\"true\"\r\n         },\r\n         {\r\n            \"label\":\"미적용\",\r\n            \"value\":\"false\"\r\n         }\r\n      ]\r\n   }\r\n}"),
    radio_values("radio (values)", "{\r\n   \"name\":\"valid\",\r\n   \"type\":\"radio\",\r\n   \"label\":\"적용여부\",\r\n   \"inline\":true,\r\n   \"options\":{\r\n      \"type\":\"values\",\r\n      \"values\":[\r\n         \"A\",\r\n         \"B\",\r\n         \"C\"\r\n      ]\r\n   }\r\n}"),
    stepper("stepper","{\r\n   \"type\":\"stepper\",\r\n   \"index\":0,\r\n   \"steps\":[\r\n      {\r\n         \"title\":\"강아지\"\r\n      },\r\n      {\r\n         \"title\":\"고양이\"\r\n      },\r\n      {\r\n         \"title\":\"판다\"\r\n      }\r\n   ]\r\n}"),
    segmented_async("segmented (async)","{\r\n  \"name\": \"account\",\r\n  \"type\": \"segmented\",\r\n  \"label\": \"segmented async\",\r\n  \"options\": {\r\n    \"type\": \"async\",\r\n    \"keyMap\": {\r\n      \"label\": \"categoryName\",\r\n      \"value\": \"id\"\r\n    },\r\n    \"actionName\": \"fetchData\",\r\n    \"requiredFields\": []\r\n  },\r\n  \"defaultValue\": \"5\"\r\n}"),
    segmented_pairs("segmented (pairs)","{\r\n  \"name\": \"segmented pairs\",\r\n  \"type\": \"segmented\",\r\n  \"label\": \"segmented pairs\",\r\n  \"options\": {\r\n    \"type\": \"pairs\",\r\n    \"values\": [\r\n      {\r\n        \"label\": \"옵션 1\",\r\n        \"value\": \"1\"\r\n      }\r\n    ]\r\n  },\r\n  \"defaultValue\": \"1\"\r\n}"),
    segmented_values("segmented (values)","{\r\n  \"name\": \"segmented\",\r\n  \"type\": \"segmented\",\r\n  \"label\": \"segmented values\",\r\n  \"options\": {\r\n    \"type\": \"values\",\r\n    \"values\": [\r\n      \"규카츠\",\r\n      \"닭발\"\r\n    ]\r\n  },\r\n  \"subText\": \"오늘의 메뉴는?\",\r\n  \"defaultValue\": \"규카츠\"\r\n}"),
    select_async("select (async)","{\r\n   \"name\":\"withdrawBankCode\",\r\n   \"type\":\"select\",\r\n   \"label\":\"출금 은행\",\r\n   \"options\":{\r\n      \"type\":\"async\",\r\n      \"keyMap\":{\r\n         \"label\":\"label\",\r\n         \"value\":\"value\"\r\n      },\r\n      \"actionName\":\"fetchBankList\",\r\n      \"requiredFields\":[]\r\n   },\r\n   \"placeholder\":\"은행 선택\",\r\n   \"autocomplete\":false\r\n}"),
    select_pairs("select (pairs)","{\r\n   \"name\":\"bankCode\",\r\n   \"type\":\"select\",\r\n   \"label\":\"은행코드\",\r\n   \"options\":{\r\n      \"type\":\"pairs\",\r\n      \"values\":[\r\n         {\r\n            \"label\":\"A\",\r\n            \"value\":\"A\"\r\n         },\r\n         {\r\n            \"label\":\"B\",\r\n            \"value\":\"B\"\r\n         }\r\n      ]\r\n   },\r\n   \"placeholder\":\"은행 선택\",\r\n   \"autocomplete\":false\r\n}"),
    select_values("select (values)","{\r\n   \"name\":\"bankCode\",\r\n   \"type\":\"select\",\r\n   \"label\":\"은행코드\",\r\n   \"options\":{\r\n      \"type\":\"values\",\r\n      \"values\":[\r\n         \"A\",\r\n         \"B\",\r\n         \"C\"\r\n      ]\r\n   },\r\n   \"placeholder\":\"은행 선택\",\r\n   \"autocomplete\":false\r\n}"),
    multi_select_async("multi-select (async)","{\r\n   \"name\":\"withdrawBankCode\",\r\n   \"type\":\"multi-select\",\r\n   \"label\":\"출금 은행\",\r\n   \"options\":{\r\n      \"type\":\"async\",\r\n      \"keyMap\":{\r\n         \"label\":\"label\",\r\n         \"value\":\"value\"\r\n      },\r\n      \"actionName\":\"fetchBankList\",\r\n      \"requiredFields\":[]\r\n   },\r\n   \"placeholder\":\"은행 선택\",\r\n   \"autocomplete\":false\r\n}"),
    multi_select_pairs("multi-select (pairs)","{\r\n   \"name\":\"bankCode\",\r\n   \"type\":\"multi-select\",\r\n   \"label\":\"은행코드\",\r\n   \"options\":{\r\n      \"type\":\"pairs\",\r\n      \"values\":[\r\n         {\r\n            \"label\":\"A\",\r\n            \"value\":\"A\"\r\n         },\r\n         {\r\n            \"label\":\"B\",\r\n            \"value\":\"B\"\r\n         }\r\n      ]\r\n   },\r\n   \"placeholder\":\"은행 선택\",\r\n   \"autocomplete\":false\r\n}"),
    multi_select_values("multi-select (values)","{\r\n   \"name\":\"bankCode\",\r\n   \"type\":\"multi-select\",\r\n   \"label\":\"은행코드\",\r\n   \"options\":{\r\n      \"type\":\"values\",\r\n      \"values\":[\r\n         \"A\",\r\n         \"B\",\r\n         \"C\"\r\n      ]\r\n   },\r\n   \"placeholder\":\"은행 선택\",\r\n   \"autocomplete\":false\r\n}"),
    tree_select("tree-select","{\r\n   \"name\":\"parentId\",\r\n   \"type\":\"tree-select\",\r\n   \"options\":{\r\n      \"option\":{\r\n         \"depth\":\"depth\",\r\n         \"label\":\"name\"\r\n      },\r\n      \"select\":{\r\n         \"label\":\"fullName\",\r\n         \"value\":\"id\"\r\n      },\r\n      \"actionName\":\"fetchAll\"\r\n   }\r\n}"),
    multi_tree_select("multi-tree-select","{\r\n   \"name\":\"strReportSubTypeReadOnly\",\r\n   \"type\":\"multi-tree-select\",\r\n   \"label\":\"STR 보고유형\",\r\n   \"multi\":true,\r\n   \"options\":{\r\n      \"type\":\"async\",\r\n      \"option\":{\r\n         \"depth\":\"depth\",\r\n         \"label\":\"name\"\r\n      },\r\n      \"select\":{\r\n         \"label\":\"fullName\",\r\n         \"value\":\"id\"\r\n      },\r\n      \"actionName\":\"strReportSubTypeList\"\r\n   },\r\n   \"disabled\":true,\r\n   \"maxDepth\":1,\r\n   \"placeholder\":\"항목 선택\",\r\n   \"autocomplete\":true,\r\n   \"defaultValue\":\"{{strReportSubType}}\",\r\n   \"validationMessage\":{\r\n      \"empty\":\"항목을 선택해주세요.\"\r\n   }\r\n}"),
    bank_account_select("bank-account-select","{\r\n   \"type\":\"bank-account-select\",\r\n   \"name\":\"받는계좌\",\r\n   \"action\":\"fetchAccountList\",\r\n   \"defaultValueKey\":\"isMainAccount\",\r\n   \"fieldMap\":{\r\n      \"bankName\":{\r\n         \"fromField\":\"bankName\"\r\n      },\r\n      \"bankCode\":{\r\n         \"fromField\":\"bankCode\",\r\n         \"toField\":\"depositBankCode\"\r\n      },\r\n      \"accountNo\":{\r\n         \"fromField\":\"accountNo\",\r\n         \"toField\":\"depositAccountNumber\"\r\n      }\r\n   }\r\n}"),
    tab("tab","{\r\n   \"name\":\"tabCategory\",\r\n   \"type\":\"tab\",\r\n   \"options\":{\r\n      \"type\":\"pairs\",\r\n      \"values\":[\r\n         {\r\n            \"label\":\"퇴근!!\",\r\n            \"value\":\"퇴근\"\r\n         },\r\n         {\r\n            \"label\":\"출근...\",\r\n            \"value\":\"출근\"\r\n         }\r\n      ]\r\n   },\r\n   \"defaultValue\":\"퇴근\"\r\n}"),
    text("text","{\r\n   \"name\":\"amount\",\r\n   \"type\":\"text\",\r\n   \"label\":\"금액\",\r\n   \"required\":true,\r\n   \"defaultValue\":{\r\n      \"format\":\"{{amount}}\"\r\n   },\r\n   \"pattern\":\"(^\\\\d+$)|(^\\\\s*$)\",\r\n   \"unit\":\"원\",\r\n   \"normalizeEmptyValue\":\"null\",\r\n   \"placeholder\":\"금액 입력\"\r\n}"),
    textarea("textarea","{\r\n   \"name\":\"name\",\r\n   \"type\":\"textarea\",\r\n   \"placeholder\":\"이름 입력\",\r\n   \"label\":\"이름\",\r\n   \"required\":true,\r\n   \"defaultValue\":\"{{name}}\",\r\n   \"rows\":6,\r\n   \"showTextCount\":true,\r\n   \"resize\":\"vertical\",\r\n   \"autosize\":true,\r\n   \"normalizeEmptyValue\":\"null\"\r\n}"),
    toggle("toggle","{\r\n   \"name\":\"toggleEx1\",\r\n   \"type\":\"toggle\",\r\n   \"label\":\"토글\",\r\n   \"labelOn\":\"토글의 상태가 On 일 경우 보여줄 라벨\",\r\n   \"labelOff\":\"토글의 상태가 Off 일 경우 보여줄 라벨\"\r\n}"),
    toggle_checkbox("toggle (checkbox)","{\r\n   \"name\":\"toggleEx2\",\r\n   \"type\":\"toggle\",\r\n   \"label\":\"토글선택\",\r\n   \"checkbox\":true\r\n}");

    private final String value;
    private final String format;

    private static final Map<String,FieldType> ENUM_MAP;
    static {
        Map<String,FieldType> map = new ConcurrentHashMap<>();
        for (FieldType instance : FieldType.values()) {
            map.put(instance.getValue(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static FieldType get (String value) {
        return ENUM_MAP.get(value);
    }

}
