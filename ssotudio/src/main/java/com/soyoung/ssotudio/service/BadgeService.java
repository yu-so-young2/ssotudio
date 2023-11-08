package com.soyoung.ssotudio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyoung.ssotudio.constant.MetaBoolean;
import com.soyoung.ssotudio.domain.Badge.ContentType;
import com.soyoung.ssotudio.domain.Badge.ContentBadge;
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
    
    public String makeBadges(RequestContentBadge requestContentBadge) throws JsonProcessingException {
        log.info("makeBadges()");
        List<ContentBadge.BadgeValue> badgeValues = mapToBadgeValues(requestContentBadge);
        ContentBadge contentBadge = getContentBadge(requestContentBadge, badgeValues);

        return om.writer(defaultPrettyPrinter).writeValueAsString(contentBadge);
    }

    private ContentBadge getContentBadge(RequestContentBadge requestContentBadge, List<ContentBadge.BadgeValue> badgeValues) {
        return ContentBadge.builder()
                .type(ContentType.badge)
                .key(requestContentBadge.getKey())
                .values(badgeValues)
                .build();
    }

    private List<ContentBadge.BadgeValue> mapToBadgeValues(RequestContentBadge requestContentBadge) {
        return requestContentBadge.getValues().stream()
                .map(value -> ContentBadge.BadgeValue.builder()
                        .color(value.getColor())
                        .variant(value.getVariant())
                        .label(value.getLabel())
                        .value(getValue(value))
                        .build()
                )
                .collect(Collectors.toList());
    }

    private Object getValue(ContentBadge.BadgeValue requestBadgeValue) {
        Object value = requestBadgeValue.getValue();
        if (value.equals(MetaBoolean.TRUE)) {
            return true;
        } else if (value.equals(MetaBoolean.FALSE)) {
            return false;
        }
        return value;
    }
}
