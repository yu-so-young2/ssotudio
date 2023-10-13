package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.dto.Badge;
import com.soyoung.ssotudio.dto.RequestAPIObjectDto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class MetaService {

    private final Logger LOGGER = LoggerFactory.getLogger(MetaService.class);

    @Autowired
    public MetaService() {
    }

    // string Json 들어오면 columns 만들어주기
    public String makeColumns(RequestAPIObjectDto requestAPIObjectDto) throws ParseException {
        LOGGER.info("makeColumns()");

        // String -> Json Object 변환
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(requestAPIObjectDto.object);

        // Json Object -> Columns 만들기
        HashMap map = jsonObject;
        String output = generateJson(map);

        return output;
    }

    private static String generateJson(HashMap input) {
        JSONObject root = new JSONObject();
        List<String> order = new ArrayList<>();
        JSONObject columns = new JSONObject();

        Iterator i = input.keySet().iterator();
        while(i.hasNext()) {
            String key = (String)i.next(); // key 추출

            // order에 추가
            order.add(key);

            // columns에 추가
            JSONObject column = new JSONObject();
            List<JSONObject> contents = new ArrayList<>();
            JSONObject content = new JSONObject();
            content.put("key", key);
            content.put("type","string");
            contents.add(content);

            column.put("label",key);
            column.put("contents", contents);
            columns.put(key, column);

        }

        root.put("order",order);
        root.put("columns",columns);

        return root.toString();
    }

    public String makeBadges(Badge requestBadge) throws JsonProcessingException {
        // Object 생성
        Badge newBadge = new Badge();
        List<Badge.BadgeValue> badgeValueList = new ArrayList<>();
        for (Badge.BadgeValue requestBadgeValue : requestBadge.getValues()) {

            badgeValueList.add(Badge.BadgeValue.builder()
                            .color(requestBadgeValue.getColor())
                            .variant(requestBadgeValue.getVariant())
                            .label(requestBadgeValue.getLabel())
                            .value(requestBadgeValue.getValue().equals("true")?true:requestBadgeValue.getValue().equals("false")?false:requestBadgeValue.getValue())
                    .build());
        }

        newBadge.setKey(requestBadge.getKey()); // key 설정
        newBadge.setValues(badgeValueList); // values 설정


        // Object -> Json String으로 변환
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(newBadge);
        System.out.println(jsonString);

        return jsonString;
    }
}