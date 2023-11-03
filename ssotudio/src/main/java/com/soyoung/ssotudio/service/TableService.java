package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.exception.CustomException;
import com.soyoung.ssotudio.exception.ExceptionType;
import com.soyoung.ssotudio.domain.Columns.Columns;
import com.soyoung.ssotudio.dto.request.JsonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TableService {
    private final DefaultPrettyPrinter defaultPrettyPrinter;
    private final ObjectMapper om;

    // string Json 들어오면 columns 만들어주기
    public String makeColumns(JsonDto jsonDto) throws JsonProcessingException {

        try {
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
            return om.writer(defaultPrettyPrinter).writeValueAsString(root);

        } catch (ParseException e) {
            throw new CustomException(ExceptionType.INVALID_JSON_FORMAT);
        } catch (ClassCastException e) {
            throw new CustomException(ExceptionType.INVALID_JSON_FORMAT);

        }

    }

}