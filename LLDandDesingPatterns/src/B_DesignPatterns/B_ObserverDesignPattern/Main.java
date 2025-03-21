package B_DesignPatterns.B_ObserverDesignPattern;

import B_DesignPatterns.B_ObserverDesignPattern.Observers.EmailNotifier;
import B_DesignPatterns.B_ObserverDesignPattern.Observers.MessageNotifier;
import B_DesignPatterns.B_ObserverDesignPattern.Payment.*;

public class Main {

    /**
     * The observer design pattern is a behavioral design pattern
     * that allows an object to notify multiple dependent objects ( Observers ) whenever its state changes automatically
     </p>
     * Useful when multiple objects need to react to changes in another object
     * @param args : initial arguments
     */
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.addObserver(new EmailNotifier());
        paymentProcessor.addObserver(new MessageNotifier());

        Payment payment1 = new HDFCCreditCard();
        paymentProcessor.processPayment(payment1);

        Payment payment2 = new HSBCCreditCard();
        paymentProcessor.processPayment(payment2);

        Payment payment3 = new AMEXCreditCard();
        paymentProcessor.processPayment(payment3);

        Payment payment4 = new PhonePayPayment();
        paymentProcessor.processPayment(payment4);

        Payment payment5= new PayPalPayment();
        paymentProcessor.processPayment(payment5);
    }
}
