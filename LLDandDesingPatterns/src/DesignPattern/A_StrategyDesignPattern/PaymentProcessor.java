package DesignPattern.A_StrategyDesignPattern;

import DesignPattern.A_StrategyDesignPattern.Payment.Payment;

public class PaymentProcessor {
    public void processPayment(Payment payment){
        payment.pay();
    }
}
