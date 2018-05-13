package com.MeterReads.MeterReads.DataObjects;

public class MeterReadingAcceptance {

    private boolean successfullyIngested = false;

    public MeterReadingAcceptance(MeterReading meterReading) {

    }

    public boolean isSuccessfullyIngested() {
        return successfullyIngested;
    }
}
