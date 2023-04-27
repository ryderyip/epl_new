package ict.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class InstantParser {
    private static Instant parseInstant(String stringDate, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        ZoneId zoneId = ZoneId.of("Asia/Hong_Kong");
        return LocalDateTime.parse(stringDate, dateTimeFormatter).atZone(zoneId).toInstant();
    }

    public static Instant parseInstantFromHtmlDatetime(String stringDate) {
        return parseInstant(stringDate, DateTimeConstants.YYYY_MM_DD_HH_MM);
    }

    public static Instant parseInstantFromDatabase(String stringDate) {
        return parseInstant(stringDate, DateTimeConstants.YYYY_MM_DD_HH_MM_SS);
    }
}

