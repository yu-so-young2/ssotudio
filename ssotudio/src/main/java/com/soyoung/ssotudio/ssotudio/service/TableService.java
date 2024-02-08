package com.soyoung.ssotudio.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.common.exception.CustomException;
import com.soyoung.ssotudio.ssotudio.exception.ExceptionType;
import com.soyoung.ssotudio.ssotudio.dto.table.Columns;
import com.soyoung.ssotudio.ssotudio.dto.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
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
    public String makeColumns(Json jsonDto) {

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

        } catch (ParseException | JsonProcessingException | ClassCastException e) {
            throw new CustomException(ExceptionType.INVALID_JSON_FORMAT);
        }

    }

    public String cleanColumns(Json jsonDto) {
        try {
            log.info("cleanColumns()");

            // String -> Object 변환
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonDto.object);

            // order 추출
            // columns 추출
            JSONArray inputOrder = (JSONArray) jsonObject.get("order");
            JSONObject inputColumns = (JSONObject) jsonObject.get("columns");
            JSONObject outputColumns = new JSONObject();

            // order에 있는 column만 outputColumns에 추가
            Iterator i = inputOrder.iterator();
            while(i.hasNext()) {
                String key = (String) i.next();
                Object column = inputColumns.get(key);
                if(column == null) {
                    System.out.println("here!!");
//                    Map<String, Object> newColumn = new JSONObject();
//                    newColumn.put()
                Columns.Column.Content content = Columns.Column.Content.builder().key(key).type("string").build();
                List<Columns.Column.Content> contents = new ArrayList<>();
                contents.add(content);
                column = Columns.Column.builder().label(key).contents(contents).build();
                }
                outputColumns.put(key, column);
            }

            LinkedHashMap<String, Object> root = new LinkedHashMap<>();
            root.put("order", inputOrder);
            root.put("columns", outputColumns);

            // Object -> Json String으로 변환
            return om.writer(defaultPrettyPrinter).writeValueAsString(root);
        } catch (ParseException | JsonProcessingException e) {
            throw new CustomException(ExceptionType.INVALID_JSON_FORMAT);
        } catch (NullPointerException e) {
            throw new CustomException(ExceptionType.COLUMNS_NOT_FOUND);
        }

    }
}