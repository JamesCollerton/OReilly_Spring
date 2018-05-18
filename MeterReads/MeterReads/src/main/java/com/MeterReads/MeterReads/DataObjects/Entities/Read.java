package com.MeterReads.MeterReads.DataObjects.Entities;

/**
 * This is the nested Read object in the schema and is
 * contained in the larger MeterReading class.
 */
public class Read {

    private String type;
    private long registerId;
    private long value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(long registerId) {
        this.registerId = registerId;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
