package com.MeterReads.MeterReads.Services.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;

import java.util.List;

public interface MeterReadingRepository extends CrudRepository<MeterReading, Long> {

    List<MeterReading> findByCustomerIdAndSerialNumber(String customerId, long serialNumber);

}
