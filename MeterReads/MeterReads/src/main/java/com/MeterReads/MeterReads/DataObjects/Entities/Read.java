package com.MeterReads.MeterReads.DataObjects.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * This is the nested Read object in the schema and is
 * contained in the larger MeterReading class.
 */
@Data
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
}
