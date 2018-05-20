package com.MeterReads.MeterReads.Utils.Parsing;

import antlr.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringParserTest {

    @Test
    public void parseLong_ValidLong_ParsesCorrectly() {
        StringParser.parseLong("1");
    }

    @Test
    public void parseLong_String_ParsesCorrectly() {
        StringParser.parseLong("Hello");
    }

//    @Test
//    public void parseLong_ValidLong_ParsesCorrectly() {
//
//    }

//    @Test
//    public void parseLong_ValidLong_ParsesCorrectly() {
//
//    }

}