package com.soyoung.ssotudio.controller;

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
    public ResponseEntity getColumns(@RequestBody RequestAPIObjectDto requestAPIObjectDto) throws ParseException {
        LOGGER.info("getColumns()");
        String output = metaService.makeColumns(requestAPIObjectDto.object);

//        Columns columns = Columns.builder().columns(output).build();

        // return API response
        ApiResponse.SuccessDetails result = ApiResponse.SuccessDetails.builder().result(output).build();
        ApiResponse apiResponse = ApiResponse.builder()
                .resultType("SUCCESS")
                .error(null)
                .success(result).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/badges")
    public ResponseEntity getBadges(@RequestBody RequestBadgeDto requestBadgeDto) {
        LOGGER.info("getBadges()");
        return null;
    }

}
