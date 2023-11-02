package com.soyoung.ssotudio.service;

import com.soyoung.ssotudio.domain.Field.FieldType;
import com.soyoung.ssotudio.dto.response.EnumDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FormService {

    public List<EnumDto> getFormFieldTypes() {
        log.info("getFormFieldTypes()");
        List<EnumDto> formFieldTypes = new ArrayList<>();
        for (FieldType type : FieldType.values()) {
            formFieldTypes.add(EnumDto.builder().label(type.getValue()).value(type.getValue()).build());
        }
        return formFieldTypes;
    }

    public String getFormFieldDefaultFormat(String type) {
        log.info("getFormFieldDefaultFormat() : "+type);
        String format = FieldType.get(type).getFormat();

        return format;
    }
}