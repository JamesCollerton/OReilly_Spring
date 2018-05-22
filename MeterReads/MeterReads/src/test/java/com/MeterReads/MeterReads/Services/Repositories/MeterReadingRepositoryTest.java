package com.MeterReads.MeterReads.Services.Repositories;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.DataObjects.Entities.Read;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MeterReadingRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private MeterReadingRepository meterReadingRepository;
    
    @Test
    public void saveAndFindMeterReading_ValidMeterReading_ReturnsCorrectly() {

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

        testEntityManager.persist(meterReading);
        testEntityManager.flush();

        // Act
        List<MeterReading> returnedMeterReadings =
                meterReadingRepository.findByCustomerIdAndSerialNumber(meterReading.getCustomerId(), meterReading.getSerialNumber());

        // Assert
        assertThat(returnedMeterReadings, contains(meterReading));
    }

}