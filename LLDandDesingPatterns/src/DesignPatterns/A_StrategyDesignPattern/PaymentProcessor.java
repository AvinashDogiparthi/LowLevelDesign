package DesignPatterns.A_StrategyDesignPattern;

import DesignPatterns.A_StrategyDesignPattern.Payment.Payment;

public class PaymentProcessor {
    public void processPayment(Payment payment){
        payment.pay();
    }
}
