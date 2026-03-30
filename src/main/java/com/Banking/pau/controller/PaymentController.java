package com.Banking.pau.controller;

import com.Banking.pau.model.PaymentRecord;
import com.Banking.pau.payment.PaymentManager;
import com.Banking.pau.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    private final PaymentManager paymentManager;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentController(PaymentManager paymentManager, PaymentRepository paymentRepository) {
        this.paymentManager = paymentManager;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("payments", paymentRepository.findAll());
        return "index";
    }

    @PostMapping("/process")
    public String processPayment(@RequestParam String method, 
                                 @RequestParam double amount, 
                                 Model model) {
        paymentManager.managePayment(method, amount);
        paymentRepository.save(new PaymentRecord(method, amount));
        model.addAttribute("message", "Processed " + method + " Payment of amount: " + amount);
        model.addAttribute("payments", paymentRepository.findAll());
        return "index";
    }
}
