package com.MeterReads.MeterReads.Utils.Timing;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsExceptionTestHelper;
import com.MeterReads.MeterReads.Utils.Parsing.StringParser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MillisTimerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void startFinishGetTime_UsedCorrectly_ReturnsResultOverZero() throws MeterReadsException, InterruptedException {
        MillisTimer millisTimer = new MillisTimer();
        millisTimer.start();
        long startTime = System.currentTimeMillis();

        // Make sure some time has elapsed
        while(System.currentTimeMillis() < startTime + 100);

        millisTimer.finish();
        assertTrue(millisTimer.getTime() > 0);
    }

    @Test
    public void startFinishGetTime_FinishCalledBeforeStart_ThrowsException() throws MeterReadsException {
        MeterReadsExceptionTestHelper.expectMessage(expectedException, MillisTimer.TIMER_FINISHED_BEFORE_STARTED);
        MillisTimer millisTimer = new MillisTimer();
        millisTimer.finish();
    }

}