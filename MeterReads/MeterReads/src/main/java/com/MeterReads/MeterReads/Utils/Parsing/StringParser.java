package com.MeterReads.MeterReads.Utils.Parsing;

/**
 * This is a class used for wrapping up parsing strings
 * to different forms.
 */
public class StringParser {

    /**
     * This parses a string to a long
     *
     * @param input String that we would like parsed
     *
     * @return The long equivalent of the string.
     */
    public static long parseLong(String input) {
        return Long.parseLong(input);
    }

}
