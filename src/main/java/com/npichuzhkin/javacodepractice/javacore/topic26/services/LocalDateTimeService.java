package com.npichuzhkin.javacodepractice.javacore.topic26.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LocalDateTimeService {
    public String convertLocalDateTime(LocalDateTime localDateTime){
        return localDateTime.getYear() + ":"
                + localDateTime.getMonth() + ":"
                + localDateTime.getDayOfMonth() + "##"
                + localDateTime.getHour() + ":"
                + localDateTime.getMinute() + ":"
                + localDateTime.getSecond() + ":"
                + localDateTime.getNano();
    }
}
