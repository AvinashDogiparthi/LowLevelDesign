package B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.PaymentValidator;

public class PayPalPaymentValidator implements PaymentValidator{

    @Override
    public boolean validatePayment(double amount){
        System.out.println("Validating payment using PayPal");
        return amount > 0;
    }
}
