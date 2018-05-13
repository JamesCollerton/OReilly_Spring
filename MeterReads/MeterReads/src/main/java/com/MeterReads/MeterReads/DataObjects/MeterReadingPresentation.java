package com.MeterReads.MeterReads.DataObjects;

public class MeterReadingPresentation {

    private String customerId;
    private String mpxn;

    public MeterReadingPresentation(String customerId, String mpxn) {
        this.customerId = customerId;
        this.mpxn = mpxn;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMpxn() {
        return mpxn;
    }
}
