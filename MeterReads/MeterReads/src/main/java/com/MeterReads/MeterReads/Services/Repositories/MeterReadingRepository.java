package com.MeterReads.MeterReads.Services.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;

public interface MeterReadingRepository extends CrudRepository<MeterReading, Long> {

//    MeterReading findByFirstName(String firstName);
//
//    List<MeterReading> findByLastName(String lastName);

}
