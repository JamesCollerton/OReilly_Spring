package com.MeterReads.MeterReads.DataObjects;

/**
 * This is used to handle any requests for data from the API. When
 * a request comes in with the given parameters they are fed to the
 * constructor of this object that handles the request.
 */
public class MeterReadingPresentation {

    private String customerId;
    private String mpxn;

    /**
     * Constructor that takes in the parameters of the request. Once
     * this has been instantiated you can use the object to search for
     * the data.
     *
     * @param customerId The customer Id for the reading given by the request
     * @param mpxn The meter point number for the reading given by the request
     */
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
