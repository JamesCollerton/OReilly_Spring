package com.MeterReads.MeterReads.DataObjects.Entities;

import com.MeterReads.MeterReads.Utils.DateTime.DateTimeUtils;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * This object maps to the below schema and is used for ingesting
 * JSON from requests to the API.
 *
 * {
 *    "customerId": "identifier123",
 *    "serialNumber": "27263927192",
 *    "mpxn": "14582749",
 *    "read": [
 *          {"type": "ANYTIME", "registerId": "387373", "value": "2729"},
 *          {"type": "NIGHT", "registerId": "387373", "value": "2892"}
 *    ],
 *    "readDate": "2017-11-20T16:19:48+00:00Z"
 * }
 */
public class MeterReading {

    private String customerId;
    private long serialNumber;
    private long mpxn;
    private List<Read> read;
    private OffsetDateTime readDate;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getMpxn() {
        return mpxn;
    }

    public void setMpxn(long mpxn) {
        this.mpxn = mpxn;
    }

    public List<Read> getRead() {
        return read;
    }

    public void setRead(List<Read> read) {
        this.read = read;
    }

    public OffsetDateTime getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = DateTimeUtils.parseISO8601Date(readDate);
    }

}
