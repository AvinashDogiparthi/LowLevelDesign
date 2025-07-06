package V_HotelManagementSystem.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Processing credit card payment of amount: " + amount);
    }
}
