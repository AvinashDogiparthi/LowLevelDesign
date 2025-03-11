package B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory;

import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment.Payment;
import B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator.PaymentValidator;

public interface PaymentAbstractFactory {
    Payment createPayment();
    PaymentValidator createPaymentValidator();
}
