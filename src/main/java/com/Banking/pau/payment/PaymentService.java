package com.Banking.pau.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${payment.api.endpoint:https://api.payments.com/v1}")
    private String apiEndpoint;

    private final PaymentMethod defaultPaymentMethod;
    private final PaymentMethod upiPaymentMethod;
    private final PaymentMethod netBankingPaymentMethod;

    @Autowired
    public PaymentService(PaymentMethod defaultPaymentMethod, 
                          @Qualifier("upiPayment") PaymentMethod upiPaymentMethod,
                          @Qualifier("netBankingPayment") PaymentMethod netBankingPaymentMethod) {
        this.defaultPaymentMethod = defaultPaymentMethod;
        this.upiPaymentMethod = upiPaymentMethod;
        this.netBankingPaymentMethod = netBankingPaymentMethod;
    }

    public void payWithDefault(double amount) {
        System.out.println("Using endpoint: " + apiEndpoint);
        defaultPaymentMethod.processPayment(amount);
    }

    public void payWithUpi(double amount) {
        System.out.println("Using endpoint: " + apiEndpoint);
        upiPaymentMethod.processPayment(amount);
    }

    public void payWithNetBanking(double amount) {
        System.out.println("Using endpoint: " + apiEndpoint);
        netBankingPaymentMethod.processPayment(amount);
    }
}
