package com.soyoung.ssotudio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soyoung.ssotudio.dto.*;

import com.soyoung.ssotudio.service.MetaService;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MetaController {
    private final Logger LOGGER = LoggerFactory.getLogger(MetaController.class);

    private static MetaService metaService;

    @Autowired
    public MetaController(MetaService metaService) {
        this.metaService = metaService;
    }

    @PostMapping("/columns")
    public ResponseEntity getColumns(@RequestBody JsonDto jsonDto) throws JsonProcessingException, ParseException {
        LOGGER.info("getColumns()");

        String jsonString = metaService.makeColumns(jsonDto);

        // return API response
        ApiResponse.SuccessDetails result = ApiResponse.SuccessDetails.builder().result(jsonString).build();
        ApiResponse apiResponse = ApiResponse.builder()
                .resultType("SUCCESS")
                .error(null)
                .success(result).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/badges")
    public ResponseEntity getBadges(@RequestBody ContentBadge requestContentBadge) throws JsonProcessingException {
        LOGGER.info("getBadges()");

        String jsonString = metaService.makeBadges(requestContentBadge);

        // return API response
        ApiResponse.SuccessDetails result = ApiResponse.SuccessDetails.builder().result(jsonString).build();
        ApiResponse apiResponse = ApiResponse.builder()
                .resultType("SUCCESS")
                .error(null)
                .success(result).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
