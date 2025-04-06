package B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment;

public class PayPalPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Paying amount using PayPal: " + amount);
    }
}
