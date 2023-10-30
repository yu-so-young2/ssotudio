package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.domain.Columns.Columns;
import com.soyoung.ssotudio.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TableService {

    // string Json 들어오면 columns 만들어주기
    public String makeColumns(JsonDto jsonDto) throws JsonProcessingException, ParseException {
        log.info("makeColumns()");

        // Object 생성
        Columns root = new Columns();
        Map<String, Columns.Column> columns = new JSONObject();
        List<String> order = new ArrayList<>();

        // 1. key 추출
        // String -> Json Object 변환
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonDto.object);
        HashMap map = jsonObject;
        Iterator i = map.keySet().iterator();
        while (i.hasNext()) {
            String key = (String) i.next(); // key 추출

            // 2. order 추가
            order.add(key);

            // 3. columns 추가
            Columns.Column.Content content = Columns.Column.Content.builder()
                    .key(key)
                    .type("string")
                    .build();
            List<Columns.Column.Content> contents = new ArrayList<>();
            contents.add(content);

            Columns.Column column = Columns.Column.builder()
                    .label(key)
                    .contents(contents)
                    .build();

            columns.put(key, column);

        }

        root.setOrder(order);
        root.setColumns(columns);

        // Object -> Json String으로 변환
        ObjectMapper mapper = new ObjectMapper();

        // 리스트 내부의 요소를 줄 바꿈과 들여쓰기로 출력하기 위해 Indenter 설정
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter.Indenter indenter = new DefaultIndenter("  ", "\n");
        printer = printer.withArrayIndenter(indenter);

        String jsonString = mapper.writer(printer).writeValueAsString(root);

        System.out.println(jsonString);

        return jsonString;
    }

}