package com.MeterReads.MeterReads.DataObjects;

/**
 * This class is used to ingest a meter reading and then return a
 * successfully ingested status or not.
 */
public class MeterReadingAcceptance {

    private boolean successfullyIngested = false;

    /**
     * The constructor is fed with the meter reading from the request which
     * can then be ingested. Depending on the success of the ingestion it
     * will set the flag to true or false.
     *
     * @param meterReading The MeterReading object to be ingested.
     */
    public MeterReadingAcceptance(MeterReading meterReading) {

    }

    public boolean isSuccessfullyIngested() {
        return successfullyIngested;
    }
}
