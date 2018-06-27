package com.MeterReads.MeterReads.Utils.DateTime;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is a utilities class used for all date/ time operations
 */
public class DateTimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXXVV");

    /**
     * A method used to parse ISO8601 date strings. It uses a custom formatter
     * to allow for offsets as well as the specification of timezones.
     *
     * @param dateString The string to be parsed as a date
     *
     * @return The parsed datetime.
     */
    public static OffsetDateTime parseISO8601Date(String dateString) {
        return OffsetDateTime.parse(dateString, FORMATTER);
    }

}
