package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.domain.Content.Badge;
import com.soyoung.ssotudio.domain.Content.Button;
import com.soyoung.ssotudio.domain.Content.ContentType;
import com.soyoung.ssotudio.dto.request.RequestContentBadge;
import com.soyoung.ssotudio.dto.request.RequestContentButton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ButtonService {
    
    private final DefaultPrettyPrinter defaultPrettyPrinter;
    private final ObjectMapper om;
    
    public String makeButton(RequestContentButton requestContentButton) throws JsonProcessingException {
        log.info("makeBadges()");
        Button.TargetContainer targetContainer = mapToTargetContainer(requestContentButton);
        Button button = getContentButton(requestContentButton, targetContainer);

        return om.writer(defaultPrettyPrinter).writeValueAsString(button);
    }

    private Button getContentButton(RequestContentButton requestContentButton, Button.TargetContainer targetContainer) {
        return Button.builder()
                .type(ContentType.button)
                .value(requestContentButton.getValue())
                .color(requestContentButton.getColor())
                .variant(requestContentButton.getVariant())
                .targetContainer(targetContainer)
                .build();
    }

    private Button.TargetContainer mapToTargetContainer(RequestContentButton requestContentButton) {
        Map<String, Button.TargetContainer.Param> params = mapToParams(requestContentButton);
        return Button.TargetContainer.builder()
                .type(requestContentButton.getTargetContainer().getType())
                .codeName(requestContentButton.getTargetContainer().getCodeName())
                .params(params)
                .build();
    }

    private Map<String, Button.TargetContainer.Param> mapToParams(RequestContentButton requestContentButton) {
        return requestContentButton.getTargetContainer().getParams().stream().collect(Collectors.toMap(
                param -> param.getTransferKey(),
                param -> Button.TargetContainer.Param.builder().key(param.getOriginKey()).build()
        ));
    }

}
