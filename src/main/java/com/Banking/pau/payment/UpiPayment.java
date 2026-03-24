package com.Banking.pau.payment;

import org.springframework.stereotype.Service;

@Service("upiPayment")
public class UpiPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment of amount: " + amount);
    }
}
