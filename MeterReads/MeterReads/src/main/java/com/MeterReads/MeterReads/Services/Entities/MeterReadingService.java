package com.MeterReads.MeterReads.Services.Entities;

import com.MeterReads.MeterReads.Services.Repositories.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;

import java.util.List;

//@Service
public class MeterReadingService {

    private MeterReading meterReading;

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    public MeterReadingService(MeterReading meterReading) {
        this.meterReading = meterReading;
    }

    /**
     * Make sure customer Id, serial number, mpxn is always unique and registerId is unique within that mpxn
     */
    public void validate() {

        List<MeterReading> customerIdSerialNumberMpxnMatch =
                meterReadingRepository.findByCustomerIdOrSerialNumberOrMpxn(
                        meterReading.getCustomerId(),
                        meterReading.getSerialNumber(),
                        meterReading.getMpxn()
                );

    }

}
