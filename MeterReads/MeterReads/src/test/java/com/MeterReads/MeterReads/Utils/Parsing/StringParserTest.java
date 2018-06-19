package com.MeterReads.MeterReads.Utils.Parsing;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import org.junit.Test;

public class StringParserTest {

    @Test
    public void parseLong_ValidLong_ParsesCorrectly() throws MeterReadsException {
        StringParser.parseLong("1");
    }

    /**
     * TODO: Decide what we want to do here.
     */
    @Test
    public void parseLong_String_ParsesIncorrectly() {
        StringParser.parseLong("Hello");
    }

}