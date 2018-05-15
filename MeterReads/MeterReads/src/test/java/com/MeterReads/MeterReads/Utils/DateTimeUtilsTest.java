package com.MeterReads.MeterReads.Utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DateTimeUtilsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseISO8601Date_StandardDate_ParsesCorrectly() {
        assertThat(DateTimeUtils.parseISO8601Date("2017-11-20T16:19:48+00:00Z"), is(OffsetDateTime.parse("2017-11-20T16:19:48+00:00")));
    }

    @Test
    public void parseISO8601Date_EndDate_ParsesCorrectly() {
        assertThat(DateTimeUtils.parseISO8601Date("9999-12-31T23:59:59+00:00Z"), is(OffsetDateTime.parse("9999-12-31T23:59:59+00:00")));
    }

    @Test
    public void parseISO8601Date_Offset_ParsesCorrectly() {
        assertThat(DateTimeUtils.parseISO8601Date("2017-11-20T16:19:48+01:00Z"), is(OffsetDateTime.parse("2017-11-20T16:19:48+01:00")));
    }

    @Test
    public void parseISO8601Date_InvalidYear_DoesNotParse() {
        parseISO8601Date_Invalid("Text '10000-11-20T16:19:48+00:00Z' could not be parsed", "10000-11-20T16:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidMonth_DoesNotParse() {
        parseISO8601Date_Invalid("Text '2017-13-20T16:19:48+00:00Z' could not be parsed", "2017-13-20T16:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidDay_DoesNotParse() {
        parseISO8601Date_Invalid("Text '2017-11-99T16:19:48+00:00Z' could not be parsed", "2017-11-99T16:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidHour_DoesNotParse() {
        parseISO8601Date_Invalid("Text '2017-11-01T99:19:48+00:00Z' could not be parsed", "2017-11-01T99:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidMinute_DoesNotParse() {
        parseISO8601Date_Invalid("Text '2017-11-01T19:99:48+00:00Z' could not be parsed", "2017-11-01T19:99:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidSecond_DoesNotParse() {
        parseISO8601Date_Invalid("Text '2017-11-01T19:19:99+00:00Z' could not be parsed", "2017-11-01T19:19:99+00:00Z");
    }

    /*
    Utilities
     */

    /**
     * Utility method for running tests when we expect the date to be invalid and to throw an
     * exception.
     *
     * @param exceptionMessage
     * @param dateString
     */
    private void parseISO8601Date_Invalid(String exceptionMessage, String dateString) {
        expectedException.expect(DateTimeParseException.class);
        expectedException.expectMessage(exceptionMessage);
        DateTimeUtils.parseISO8601Date(dateString);
    }

}