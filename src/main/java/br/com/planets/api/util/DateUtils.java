package br.com.planets.api.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {}

    public static String convertToString(LocalDateTime createdAt) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return createdAt.format(formatter);
    }

    public static OffsetDateTime convertToOffsetDateTime(LocalDateTime createdAt) {
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        return createdAt.atOffset(offset);
    }

    public static LocalDateTime convertToLocalDateTime(OffsetDateTime offsetDateTime) {
        if(offsetDateTime != null) {
            LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
            return  localDateTime;
        }else{
            return null;
        }
    }

}
