package com.sullivankw.CoinMetrics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy").withLocale(Locale.US);

    public static String fromLocalDate(LocalDate original) {//example, 2021-09-13
        return original.format(DATE_TIME_FORMATTER);
    }

    public static Date fromUnix(long timestamp) {
        return new Date(timestamp);
    }
}
