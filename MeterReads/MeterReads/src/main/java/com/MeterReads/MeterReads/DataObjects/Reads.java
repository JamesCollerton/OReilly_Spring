package com.MeterReads.MeterReads.DataObjects;

public class Reads {

    private String type;
    private int registerId;
    private int value;

    public Reads(String type, int registerId, int value) {
        this.type = type;
        this.registerId = registerId;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
