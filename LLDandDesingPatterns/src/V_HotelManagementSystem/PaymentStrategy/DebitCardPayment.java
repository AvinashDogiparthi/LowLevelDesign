package V_HotelManagementSystem.PaymentStrategy;

public class DebitCardPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Processing debit card payment of amount: " + amount);
    }
}
