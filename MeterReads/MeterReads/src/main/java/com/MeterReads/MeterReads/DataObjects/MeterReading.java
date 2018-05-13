package com.MeterReads.MeterReads.DataObjects;

import java.util.Date;
import java.util.List;

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
//    private int serialNumber;
//    private int mpxn;
//    private List<Reads> reads;
//    private Date readDate;

//    public MeterReading() {
//        this.customerId = customerId;
//        this.serialNumber = serialNumber;
//        this.mpxn = mpxn;
//        this.reads = reads;
//        this.readDate = readDate;
//    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

//    public int getSerialNumber() {
//        return serialNumber;
//    }
//
//    public void setSerialNumber(int serialNumber) {
//        this.serialNumber = serialNumber;
//    }
//
//    public int getMpxn() {
//        return mpxn;
//    }
//
//    public void setMpxn(int mpxn) {
//        this.mpxn = mpxn;
//    }
//
//    public List<Reads> getReads() {
//        return reads;
//    }
//
//    public void setReads(List<Reads> reads) {
//        this.reads = reads;
//    }
//
//    public Date getReadDate() {
//        return readDate;
//    }
//
//    public void setReadDate(Date readDate) {
//        this.readDate = readDate;
//    }

}
