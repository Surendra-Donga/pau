package com.Banking.pau.controller;

import com.Banking.pau.payment.PaymentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    private final PaymentManager paymentManager;

    @Autowired
    public PaymentController(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/process")
    public String processPayment(@RequestParam String method, 
                                 @RequestParam double amount, 
                                 Model model) {
        paymentManager.managePayment(method, amount);
        model.addAttribute("message", "Processed " + method + " Payment of amount: " + amount);
        return "index";
    }
}
