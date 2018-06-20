package com.MeterReads.MeterReads.Utils.Exceptions;

import org.junit.rules.ExpectedException;

public class MeterReadsExceptionTestHelper {

    public static void expectMessage(ExpectedException expectedException, String message) {
        expectedException.expect(MeterReadsException.class);
        expectedException.expectMessage(message);
    }

}
