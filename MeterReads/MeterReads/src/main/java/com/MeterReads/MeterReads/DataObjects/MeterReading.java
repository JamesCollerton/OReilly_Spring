package com.MeterReads.MeterReads.DataObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

/**
 * {
 *         "customerId": "identifier123",
 *         "serialNumber": "27263927192",
 *         "mpxn": "14582749",
 *         "read": [
 *             {"type": "ANYTIME", "registerId": "387373", "value": "2729"},
 *             {"type": "NIGHT", "registerId": "387373", "value": "2892"}
 *         ],
 *        "readDate": "2017-11-20T16:19:48+00:00Z"
 *    }
 */
public class MeterReading {

    private String customerId;
    private long serialNumber;
    private long mpxn;
    private List<Reads> reads;
    private String readDate;

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

    public List<Reads> getReads() {
        return reads;
    }

    public void setReads(List<Reads> reads) {
        this.reads = reads;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) throws ParseException {
        this.readDate = readDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        format.parse(readDate);
        Instant.parse(readDate);
        ZonedDateTime.parse(readDate, DateTimeFormatter.ISO_DATE_TIME);
    }

}
