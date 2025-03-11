package B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator;

public class CreditCardPaymentValidator implements PaymentValidator{

    @Override
    public boolean validatePayment(double amount) {
        System.out.println("Validating credit card payment");
        return amount > 0;
    }
}
