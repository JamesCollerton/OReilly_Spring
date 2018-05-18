package com.MeterReads.MeterReads.Services.DAO;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MeterReadingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public MeterReading insert(MeterReading meterReading){
        entityManager.persist(meterReading);
        return findById(meterReading.getMeterReadingId());
    }

    public MeterReading findById(long meterReadingId) {
        return entityManager.find(MeterReading.class, meterReadingId);
    }

//    public List<MeterReading> findByCustomerIdMPXN(String customerId, String mpxn) {
//
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<MeterReading> criteria = builder.createQuery(MeterReading.class)
//        criteria.where(builder.and(builder.equal()));
//                .add(Restrictions.eq("mpxn", mpxn)).list();
//    }
}
