package com.Banking.pau.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentManager {

    private final PaymentService paymentService;

    @Autowired
    public PaymentManager(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void managePayment(String method, double amount) {
        if ("UPI".equalsIgnoreCase(method)) {
            paymentService.payWithUpi(amount);
        } else if ("NETBANKING".equalsIgnoreCase(method)) {
            paymentService.payWithNetBanking(amount);
        } else {
            paymentService.payWithDefault(amount);
        }
    }
}
