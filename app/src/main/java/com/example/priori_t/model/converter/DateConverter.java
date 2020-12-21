package com.example.priori_t.model.converter;

import androidx.room.TypeConverter;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.TimeZone;


public class DateConverter {
    @TypeConverter
    public static ZonedDateTime fromTimeStamp(Long val) {
        ZoneId zid = TimeZone.getDefault().toZoneId();
        Instant i = Instant.ofEpochSecond(val);
        return ZonedDateTime.ofInstant(i, zid);
    }
    @TypeConverter
    public static Long fromZonedDateTime(ZonedDateTime z) {
        return z.toInstant().toEpochMilli();
    }
}
