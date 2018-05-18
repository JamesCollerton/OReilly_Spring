package com.MeterReads.MeterReads.Services.DAO;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MeterReadingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(MeterReading meterReading){
        entityManager.persist(meterReading);
        return meterReading.getMeterReadingId();
    }
}
