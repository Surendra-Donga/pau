package com.Banking.pau;

import com.Banking.pau.model.PaymentRecord;
import com.Banking.pau.payment.PaymentManager;
import com.Banking.pau.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PauApplication {

	public static void main(String[] args) {
		SpringApplication.run(PauApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(PaymentManager paymentManager, PaymentRepository paymentRepository) {
		return args -> {
			System.out.println("--- Demonstrating Payment System ---");
			paymentManager.managePayment("Card", 100.0);
			paymentRepository.save(new PaymentRecord("Card", 100.0));

			paymentManager.managePayment("UPI", 250.0);
			paymentRepository.save(new PaymentRecord("UPI", 250.0));

			paymentManager.managePayment("NETBANKING", 500.0);
			paymentRepository.save(new PaymentRecord("NETBANKING", 500.0));

			System.out.println("------------------------------------");
		};
	}

}
