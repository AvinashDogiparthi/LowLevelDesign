package B_DesignPatterns.D_AbstractFactoryDesignPattern.AbstractFactory.Payment;

public class CreditCardPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Paying amount using credit card: " + amount);
    }
}
