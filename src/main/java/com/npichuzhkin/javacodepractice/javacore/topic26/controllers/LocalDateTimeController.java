package com.npichuzhkin.javacodepractice.javacore.topic26.controllers;

import com.npichuzhkin.javacodepractice.javacore.topic26.dto.LocalDateTimeDTO;
import com.npichuzhkin.javacodepractice.javacore.topic26.services.LocalDateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LocalDateTimeController {

    private final LocalDateTimeService localDateTimeService;

    @Autowired
    public LocalDateTimeController(LocalDateTimeService localDateTimeService) {
        this.localDateTimeService = localDateTimeService;
    }


    @PostMapping("/displayTime")
    @ResponseBody
    public ResponseEntity<String> displayLocalDateTime(@RequestBody LocalDateTimeDTO localDateTimeDTO){
        return new ResponseEntity<>(localDateTimeService.convertLocalDateTime(localDateTimeDTO.getLocalDateTime()), HttpStatus.OK);
    }
}
