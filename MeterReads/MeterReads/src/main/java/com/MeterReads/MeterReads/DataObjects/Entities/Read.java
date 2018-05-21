package com.MeterReads.MeterReads.DataObjects.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Setter;

/**
 * This is the nested Read object in the schema and is
 * contained in the larger MeterReading class.
 */
@Entity
@Table(name = "read")
@lombok.Getter
@lombok.Setter
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
