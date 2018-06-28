package com.MeterReads.MeterReads.DataObjects.Entities;

import com.MeterReads.MeterReads.Utils.DateTime.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
 *
 * Note: To connect to the H2 console we need to use jdbc:h2:mem:testdb
 */
@Data
@EqualsAndHashCode(exclude = "meterReadingId")
@Entity
@Table(name = "meter_reading")
public class MeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "METER_READING_ID")
    private Long meterReadingId;

    private String customerId;
    private long serialNumber;
    private long mpxn;
    private String readDate;

    @OneToMany(
            targetEntity=Read.class,
            mappedBy="meterReading",
            fetch=FetchType.EAGER,
            cascade=CascadeType.ALL
    )
    private List<Read> read;

    @JsonIgnore
    public Long getMeterReadingId() {
        return meterReadingId;
    }

    @JsonIgnore
    public void setMeterReadingId(Long meterReadingId) {
        this.meterReadingId = meterReadingId;
    }

    public void setRead(List<Read> read) {
        for(Read individualRead: read) {
            individualRead.setMeterReading(this);
        }
        this.read = read;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    /*
        Utilities
     */

    /**
     * This is used if we want to return the readDate not as a string but
     * as an OffsetDateTime we can use in the program.
     *
     * @return The offset date time of the string
     */
    @JsonIgnore
    public OffsetDateTime getReadDateAsOffsetDateTime() {
        return DateTimeUtils.parseISO8601Date(this.readDate);
    }

}
