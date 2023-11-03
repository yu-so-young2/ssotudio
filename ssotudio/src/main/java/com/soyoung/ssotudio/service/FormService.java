package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.dto.response.EnumDto;
import com.soyoung.ssotudio.exception.CustomException;
import com.soyoung.ssotudio.exception.ExceptionType;
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
public class FormService {
    private final ResourceLoader resourceLoader;
    private final DefaultPrettyPrinter defaultPrettyPrinter;
    private final ObjectMapper om;

    public List<EnumDto> getFormFieldTypes() {
        try {
            log.info("getFormFieldTypes()");

            Resource resource = resourceLoader.getResource("classpath:Field.json");
            Map<String, JSONObject> fieldMap = om.readValue(resource.getInputStream(), new TypeReference<>() {});

            List<EnumDto> formFieldTypes = new ArrayList<>();
            for (String field : fieldMap.keySet()) {
                formFieldTypes.add(EnumDto.builder().label(field).value(field).build());
            }

            return formFieldTypes;

        } catch (IOException e) {
            throw new CustomException(ExceptionType.FIELD_FILE_NOT_FOUND);
        }
    }

    public String getFormFieldDefaultFormat(String type)  {
        try {
            log.info("getFormFieldDefaultFormat() : "+type);

            Resource resource = resourceLoader.getResource("classpath:Field.json");
            Map<String, JSONObject> fieldMap = om.readValue(resource.getInputStream(), new TypeReference<>() {});
            JSONObject field = fieldMap.get(type);

            if(field == null) {
                throw new CustomException(ExceptionType.FORM_FIELD_TYPE_NOT_FOUND);
            }

            return om.writer(defaultPrettyPrinter).writeValueAsString(field);

        } catch (IOException e) {
           throw new CustomException(ExceptionType.FIELD_FILE_NOT_FOUND);
        }
    }
}