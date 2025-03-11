package B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory;

import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment.PayPalPayment;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment.Payment;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator.PayPalPaymentValidator;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator.PaymentValidator;

public class PayPalFactory implements PaymentAbstractFactory{

    @Override
    public Payment createPayment(){
        return new PayPalPayment();
    }

    @Override
    public PaymentValidator createPaymentValidator(){
        return new PayPalPaymentValidator();
    }
}
