package com.MeterReads.MeterReads.Utils;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {

    public static OffsetDateTime parseISO8601Date(String dateString) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXXVV");
        return OffsetDateTime.parse(dateString, parser);
    }

}
