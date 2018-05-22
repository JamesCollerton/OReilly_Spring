package com.MeterReads.MeterReads.Utils.Parsing;

import antlr.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringParserTest {

    @Test
    public void parseLong_ValidLong_ParsesCorrectly() {
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