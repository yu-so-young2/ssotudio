package com.soyoung.ssotudio.service;

import com.soyoung.ssotudio.domain.Field.Field;
import com.soyoung.ssotudio.dto.response.EnumDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class FormService {

    public List<EnumDto> getFormFieldTypes() {
        String[] types = {"alert", "async_description","async_image", "border", "checkbox", "date","date_range",
                "description", "file", "hidden", "hstack", "number", "link","list",  "password", "radio",  "stepper", "text",  "textarea",    "tab",  "toggle",  "select", "multi_select", "tree_select", "multi_tree_select","bank_account_select"};
        List<EnumDto> formFieldTypes = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            String type = types[i];
            formFieldTypes.add(EnumDto.builder().label(type).value(type).build());
        }
        return formFieldTypes;
    }

    public Field getFormFieldDefaultFormat(String type) {
        return null;
    }
}