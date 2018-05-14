package com.MeterReads.MeterReads.Utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTimeUtilsTest {

    @Test
    public void parseISO8601Date() {
        DateTimeUtils.parseISO8601Date("2017-11-20T16:19:48+00:00Z");
    }

}