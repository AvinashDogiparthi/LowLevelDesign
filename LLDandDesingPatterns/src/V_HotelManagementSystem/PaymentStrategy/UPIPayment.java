package V_HotelManagementSystem.PaymentStrategy;

public class UPIPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Processing UPI payment of amount: " + amount);
    }
}
