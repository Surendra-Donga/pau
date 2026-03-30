package com.Banking.pau.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRecord {

    @Id
    private String id;
    private String method;
    private double amount;
    private LocalDateTime timestamp;

    public PaymentRecord(String method, double amount) {
        this.method = method;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
}
