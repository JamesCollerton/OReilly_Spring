package com.MeterReads.MeterReads.Utils.Timing;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;

public class MillisTimer {

    private static final long DEFAULT_START_TIME = 0;

    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void finish() throws MeterReadsException {
        if(startTime == DEFAULT_START_TIME) {
            throw new MeterReadsException("Timer finish called before timer started");
        }
        endTime = System.currentTimeMillis();
    }

    public long getTime() {
        return endTime - startTime;
    }

}
