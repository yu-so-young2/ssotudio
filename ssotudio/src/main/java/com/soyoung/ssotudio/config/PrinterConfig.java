package com.soyoung.ssotudio.config;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 리스트 내부의 요소를 줄 바꿈과 들여쓰기로 출력하기 위해 Indenter 설정
@Configuration
public class PrinterConfig {

    private final static String INDENTER_BLANK = "  ";

    @Bean
    public DefaultPrettyPrinter defaultPrettyPrinter() {
        DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter();
        defaultPrettyPrinter.withArrayIndenter(indenter());

        return defaultPrettyPrinter;
    }

    @Bean
    public DefaultPrettyPrinter.Indenter indenter() {
        return new DefaultIndenter(INDENTER_BLANK, "\n");
    }
}
