package com.MeterReads.MeterReads.Utils.Parsing;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;

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
    public static long parseLong(String input) throws MeterReadsException {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new MeterReadsException("String " + input + " could not be parsed", e);
        }
    }

}
