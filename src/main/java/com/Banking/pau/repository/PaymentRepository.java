package com.Banking.pau.repository;

import com.Banking.pau.model.PaymentRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentRecord, String> {
}
