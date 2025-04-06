package B_DesignPatterns.A_StrategyDesignPattern;

import B_DesignPatterns.A_StrategyDesignPattern.Payment.Payment;

public class PaymentProcessor {
    public void processPayment(Payment payment){
        payment.pay();
    }
}
