package com.MeterReads.MeterReads.Services.Entities;

import org.springframework.stereotype.Service;
import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;

@Service
public class MeterReadingService {

    private MeterReading meterReading;

    public MeterReadingService(MeterReading meterReading) {
        this.meterReading = meterReading;
    }

    /**
     * Make sure customer Id, serial number, mpxn is always unique and registerId is unique within that mpxn
     */
    public void validate() {

    }

}
