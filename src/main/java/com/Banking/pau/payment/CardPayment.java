package com.Banking.pau.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Card Payment of amount: " + amount);
    }
}
