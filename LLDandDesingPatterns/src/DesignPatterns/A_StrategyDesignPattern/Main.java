package DesignPatterns.A_StrategyDesignPattern;


import DesignPatterns.A_StrategyDesignPattern.Payment.*;

public class Main {

    /**
     * We should use strategy design pattern when you need to implement different algorithms (or) behaviours for the same task.
     * @param args : initial arguments
     */
    public static void main(String[] args) {
        // Here we are clubbing together common type of payment strategies which have same behaviour or same task to execute
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        Payment payment1 = new HSBCCreditCard();
        paymentProcessor.processPayment(payment1);

        Payment payment2 = new HDFCCreditCard();
        paymentProcessor.processPayment(payment2);

        Payment payment3 = new AMEXCreditCard();
        paymentProcessor.processPayment(payment3);

        Payment payment4 = new PayPalPayment();
        paymentProcessor.processPayment(payment4);

        Payment payment5 = new PhonePayPayment();
        paymentProcessor.processPayment(payment5);

    }
}
