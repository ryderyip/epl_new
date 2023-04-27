package ict.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class InstantFormatter {
    public static String format(Instant instant, FormatStyle formatStyle) {
        return DateTimeFormatter.ofLocalizedDateTime(formatStyle)
                .withLocale(Locale.ENGLISH )
                .withZone( ZoneId.systemDefault() )
                .format(instant);
    }
}
