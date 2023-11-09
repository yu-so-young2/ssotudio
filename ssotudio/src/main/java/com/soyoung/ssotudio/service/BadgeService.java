package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.constant.MetaBoolean;
import com.soyoung.ssotudio.domain.Content.ContentType;
import com.soyoung.ssotudio.domain.Content.Badge;
import com.soyoung.ssotudio.dto.request.RequestContentBadge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BadgeService {
    
    private final DefaultPrettyPrinter defaultPrettyPrinter;
    private final ObjectMapper om;
    
    public String makeBadge(RequestContentBadge requestContentBadge) throws JsonProcessingException {
        log.info("makeBadge()");
        List<Badge.BadgeValue> badgeValues = mapToBadgeValues(requestContentBadge);
        Badge badge = getContentBadge(requestContentBadge, badgeValues);

        return om.writer(defaultPrettyPrinter).writeValueAsString(badge);
    }

    private Badge getContentBadge(RequestContentBadge requestContentBadge, List<Badge.BadgeValue> badgeValues) {
        return Badge.builder()
                .type(ContentType.badge)
                .key(requestContentBadge.getKey())
                .values(badgeValues)
                .build();
    }

    private List<Badge.BadgeValue> mapToBadgeValues(RequestContentBadge requestContentBadge) {
        return requestContentBadge.getValues().stream()
                .map(value -> Badge.BadgeValue.builder()
                        .color(value.getColor())
                        .variant(value.getVariant())
                        .label(value.getLabel())
                        .value(getValue(value))
                        .build()
                )
                .collect(Collectors.toList());
    }

    private Object getValue(Badge.BadgeValue requestBadgeValue) {
        Object value = requestBadgeValue.getValue();
        if (value.equals(MetaBoolean.TRUE)) {
            return true;
        } else if (value.equals(MetaBoolean.FALSE)) {
            return false;
        }
        return value;
    }
}
