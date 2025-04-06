package B_DesignPatterns.D_AbstractFactoryDesignPattern;

import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment.Payment;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentAbstractFactory;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator.PaymentValidator;

public class Main {

    public static void main(String[] args){
        PaymentAbstractFactory paymentAbstractFactory = FactoryProducer.getFactory("CREDIT");

        Payment payment = paymentAbstractFactory.createPayment();
        PaymentValidator paymentValidator = paymentAbstractFactory.createPaymentValidator();
        if(paymentValidator.validatePayment(100)){
            payment.pay(100);
        }
    }
}
