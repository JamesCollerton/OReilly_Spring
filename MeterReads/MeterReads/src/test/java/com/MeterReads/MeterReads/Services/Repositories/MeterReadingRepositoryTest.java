package com.MeterReads.MeterReads.Services.Repositories;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.DataObjects.Entities.Read;
import com.MeterReads.MeterReads.Utils.DateTime.DateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MeterReadingRepositoryTest {

    @Autowired
    private MeterReadingRepository meterReadingRepository;
    
    @Test
    public void saveAndFindMeterReading_ValidMeterReading_ReturnsCorrectly() {

        findAndSaveMeterReading("Customer Id", 1l, 1l, "2017-11-20T16:19:48+00:00Z", 1l, "Type", 1l);

        // Arrange
        MeterReading meterReading = new MeterReading();

        meterReading.setCustomerId("Customer Id");
        meterReading.setMeterReadingId(1l);
        meterReading.setMpxn(1l);
        meterReading.setReadDate("2017-11-20T16:19:48+00:00Z");
        meterReading.setSerialNumber(1l);

        Read read = new Read();
        read.setMeterReading(meterReading);
        read.setRegisterId(1l);
        read.setType("Type");
        read.setValue(1l);

        meterReading.setRead(Collections.singletonList(read));

        MeterReading meterReadingSaved = meterReadingRepository.save(meterReading);

        // Act

        Iterable<MeterReading> returnedMeterReadingsIterator = meterReadingRepository.findAll();
        List<MeterReading> returnedMeterReadings = new ArrayList<>();
        returnedMeterReadingsIterator.forEach(returnedMeterReadings::add);

        List<Read> listOne = Collections.singletonList(returnedMeterReadings.get(0).getRead().get(0));
        List<Read> listTwo = Collections.singletonList(read);

        listOne.equals(listTwo);

        read.equals(returnedMeterReadings.get(0).getRead().get(0));

        returnedMeterReadings.get(0).equals(meterReading);

        // Assert
        assertThat(returnedMeterReadings.get(0).equals(meterReadingSaved), is(true));
    }

    /*
        Utilities
     */

    public void findAndSaveMeterReading(String customerId, long serialNumber, long mpxn, String readDateString, long registerId, String type, Long value) {

        // Arrange
        MeterReading meterReading = new MeterReading();

        meterReading.setCustomerId(customerId);
        meterReading.setMeterReadingId(serialNumber);
        meterReading.setMpxn(mpxn);
        meterReading.setReadDate(readDateString);
        meterReading.setSerialNumber(serialNumber);

        OffsetDateTime readDate = DateTimeUtils.parseISO8601Date(readDateString);

        Read read = new Read();
        read.setMeterReading(meterReading);
        read.setRegisterId(registerId);
        read.setType(type);
        read.setValue(value);

        meterReading.setRead(Collections.singletonList(read));

        // Act
        MeterReading meterReadingSaved = meterReadingRepository.save(meterReading);

        // Assert
        List<MeterReading> savedReading = meterReadingRepository.findByCustomerIdAndSerialNumberAndMpxnAndReadDate(customerId, serialNumber, mpxn, readDate);

        assertTrue(savedReading.size() == 1);
        assertThat(savedReading.get(0).equals(meterReadingSaved), is(true));

    }

}