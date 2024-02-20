package com.klagan.pvptariffservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

public class DateParse {
    private static final Logger log = LoggerFactory.getLogger(Date.class);
    public static  Optional<Date> toDate(String date){
        try {
            log.info("Start parse date from : {}",date);
            return Optional.of(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date));
        } catch (ParseException e) {
            log.error("Error parse date error: {}",e.getMessage());
            return Optional.empty();
        }
    }
}
