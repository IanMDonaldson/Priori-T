package com.example.priori_t.model.database.converter;

import androidx.room.TypeConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import kotlin.jvm.JvmStatic;

public class DateConverter {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    private static LocalDateTime ldc;

    @TypeConverter
    public static LocalDateTime toLocalDateTime(String val) {
        return LocalDateTime.parse(val, formatter);
    }
    @TypeConverter
    public static String localDateToString(LocalDateTime ldc) {
        return ldc.format(formatter);
    }
}
