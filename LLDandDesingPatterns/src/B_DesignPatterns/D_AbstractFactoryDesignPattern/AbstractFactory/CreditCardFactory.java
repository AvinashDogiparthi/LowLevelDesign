package B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory;

import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment.CreditCardPayment;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment.Payment;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator.CreditCardPaymentValidator;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator.PaymentValidator;

public class CreditCardFactory implements PaymentAbstractFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }

    @Override
    public PaymentValidator createPaymentValidator() {
        return new CreditCardPaymentValidator();
    }
}
