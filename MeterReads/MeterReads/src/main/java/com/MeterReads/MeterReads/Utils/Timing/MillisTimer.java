package com.MeterReads.MeterReads.Utils.Timing;

public class MillisTimer {

    private static final long DEFAULT_START_TIME = 0;

    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void finish() {
        if(startTime == DEFAULT_START_TIME) {
            // TODO: Decide what to throw here.
        }
        endTime = System.currentTimeMillis();
    }

    public long getTime() {
        return endTime - startTime;
    }

}
