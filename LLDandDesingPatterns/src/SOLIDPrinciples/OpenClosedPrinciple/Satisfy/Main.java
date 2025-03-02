package SOLIDPrinciples.OpenClosedPrinciple.Satisfy;

import SOLIDPrinciples.OpenClosedPrinciple.Satisfy.PaymentType.CreditCardPayment;
import SOLIDPrinciples.OpenClosedPrinciple.Satisfy.PaymentType.PayPalPayment;
import SOLIDPrinciples.OpenClosedPrinciple.Satisfy.PaymentType.Payment;

public class Main {
    public static void main(String[] args){
        Payment creditCardPayment = new CreditCardPayment();
        Payment payPalPayment = new PayPalPayment();

        PaymentProcessor paymentProcessor1 = new PaymentProcessor(creditCardPayment);
        paymentProcessor1.processPayment();

        PaymentProcessor paymentProcessor2 = new PaymentProcessor(payPalPayment);
        paymentProcessor2.processPayment();
    }
}
