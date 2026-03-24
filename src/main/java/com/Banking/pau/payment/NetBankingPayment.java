package com.Banking.pau.payment;

import org.springframework.stereotype.Service;

@Service("netBankingPayment")
public class NetBankingPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Net Banking Payment of amount: " + amount);
    }
}
