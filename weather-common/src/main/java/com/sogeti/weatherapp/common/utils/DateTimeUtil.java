package com.sogeti.weatherapp.common.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String convertUTCToTime(Long time, String timezone){
        Instant instant = Instant.ofEpochSecond(time);
        return ZonedDateTime.ofInstant(instant, ZoneId.of( timezone )).format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static String convertUTCToDateTime(Long time, String timezone){
        Instant instant = Instant.ofEpochSecond(time);
        return ZonedDateTime.ofInstant(instant, ZoneId.of( timezone )).format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm"));
    }

    public static String convertUTCToDay(Long time, String timezone){
        Instant instant = Instant.ofEpochSecond(time);
        return ZonedDateTime.ofInstant(instant, ZoneId.of( timezone )).format(DateTimeFormatter.ofPattern("dd/MM"));
    }
}
