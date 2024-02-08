package com.soyoung.ssotudio.test.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.common.exception.CustomException;
import com.soyoung.ssotudio.test.dto.Chiikawa;
import com.soyoung.ssotudio.ssotudio.dto.field.SelectOption;
import com.soyoung.ssotudio.test.exception.ExceptionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper om;

    public List<Chiikawa> getAllChiikawa() {
        try {
            log.info("getAllChiikawa()");

            Resource resource = resourceLoader.getResource("classpath:Chiikawa.json");
            Map<String, JSONObject> map = om.readValue(resource.getInputStream(), new TypeReference<>() {});

            List<Chiikawa> chiikawas = new ArrayList<>();
            for (String id : map.keySet()) {
                chiikawas.add(Chiikawa.builder()
                                .id(Integer.parseInt(id))
                                .name((String) map.get(id).get("name"))
                                .image((String) map.get(id).get("image"))
                                .html((String) map.get(id).get("html"))
                        .build());
            }

            return chiikawas;

        } catch (IOException e) {
            throw new CustomException(ExceptionType.CHIIKAWA_FILE_NOT_FOUND);
        }
    }

    public Chiikawa getChiikawa(String id)  {
        try {
            log.info("getChiikawa() : "+id);

            Resource resource = resourceLoader.getResource("classpath:Chiikawa.json");
            Map<String, JSONObject> map = om.readValue(resource.getInputStream(), new TypeReference<>() {});
            JSONObject chiikawa = map.get(id);

            if(id == null || chiikawa == null) {
                throw new CustomException(ExceptionType.CHIIKAWA_ID_NOT_FOUND);
            }

            return Chiikawa.builder()
                    .id(Integer.parseInt(id))
                    .name((String) chiikawa.get("name"))
                    .image((String) chiikawa.get("image"))
                    .html((String) chiikawa.get("html"))
                    .build();

        } catch (IOException e) {
            throw new CustomException(ExceptionType.CHIIKAWA_FILE_NOT_FOUND);
        }
    }

    public List<SelectOption> getSelectOptions(String param1, String param2) {
        List<SelectOption> enumList = new ArrayList<>();

        if("고기".equals(param1)) {
            enumList.add(SelectOption.builder().label("삼겹살").value("삼겹살").build());
            enumList.add(SelectOption.builder().label("갈비").value("갈비").build());
        }
        else if("밥".equals(param1)) {
            enumList.add(SelectOption.builder().label("비빔밥").value("비빔밥").build());
            enumList.add(SelectOption.builder().label("김치볶음밥").value("김치볶음밥").build());
        }

        if("매운거".equals(param2)) {
            enumList.add(SelectOption.builder().label("떡볶이").value("떡볶이").build());
            enumList.add(SelectOption.builder().label("마라탕").value("마라탕").build());
        }
        else if("안매운거".equals(param2)) {
            enumList.add(SelectOption.builder().label("샤브샤브").value("샤브샤브").build());
            enumList.add(SelectOption.builder().label("돌솥밥").value("돌솥밥").build());
        }

        return enumList;

    }
}
