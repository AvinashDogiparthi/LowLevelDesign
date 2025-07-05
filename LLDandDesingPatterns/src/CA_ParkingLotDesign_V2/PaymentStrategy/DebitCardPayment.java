package CA_ParkingLotDesign_V2.PaymentStrategy;

public class DebitCardPayment implements PaymentStrategy {

    @Override
    public void pay() {
        // Logic for debit card payment
        System.out.println("Payment made using Debit Card.");
    }
}
