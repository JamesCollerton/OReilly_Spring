package com.MeterReads.MeterReads.DataObjects.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * This is the nested Read object in the schema and is
 * contained in the larger MeterReading class.
 */
@Entity
@Table(name = "read")
public class Read {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readId;

    @ManyToOne
    @JoinColumn(name="meterReadingId")
    private MeterReading meterReading;

    private String type;
    private long registerId;
    private long value;

    @JsonIgnore
    public Long getReadId() {
        return readId;
    }

    @JsonIgnore
    public void setReadId(Long readId) {
        this.readId = readId;
    }

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

    @JsonIgnore
    public MeterReading getMeterReading() {
        return meterReading;
    }

    @JsonIgnore
    public void setMeterReading(MeterReading meterReading) {
        this.meterReading = meterReading;
    }
}
